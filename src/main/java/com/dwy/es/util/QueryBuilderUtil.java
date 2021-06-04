package com.dwy.es.util;

import com.dwy.es.annotation.Search;
import com.dwy.es.enums.BoolType;
import com.dwy.es.enums.BoundType;
import com.dwy.es.enums.DirectionType;
import com.dwy.es.enums.OperatorType;
import com.dwy.es.metadata.AbstractBaseCondition;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/2 17:45
 */
public class QueryBuilderUtil {

    private static  final Logger logger = LoggerFactory.getLogger(QueryBuilderUtil.class);

    private static String currentLogicalExpression = "";

    private static Map<OperatorType , String> operatorExpressionMap = new HashMap<>();

    private static Map<BoolType , String> boolExpressionMap = new HashMap<>();

    private static Map<BoundType , String> boundExpressionMap = new HashMap<>();

    static {
        operatorExpressionMap.put(OperatorType.Must," and ");
        operatorExpressionMap.put(OperatorType.Should," or ");
        operatorExpressionMap.put(OperatorType.MustNot , " and not ");
        operatorExpressionMap.put(OperatorType.Filter , " and ");
        boolExpressionMap.put(BoolType.Term , " = ");
        boolExpressionMap.put(BoolType.WildCard , " like ");
        boundExpressionMap.put(BoundType.Start , " >=");
        boundExpressionMap.put(BoundType.End , " <= ");
    }

    /**
     * 在筛选条件上额外加前置条件
     * @param obj 筛选条件
     * @param queryBuilder 查询的前置条件
     * @return org.elasticsearch.index.query.QueryBuilder
     * @create 2021/6/3 15:06
     */
    public static QueryBuilder getQueryBuilder(AbstractBaseCondition obj , BoolQueryBuilder queryBuilder){
        queryBuilder.must(getQueryBuilder(obj));
        return queryBuilder;
    }

    /**
     * 根据筛选条件自动得到筛选语句
     * @param obj 筛选条件
     * @return org.elasticsearch.index.query.QueryBuilder
     * @create 2021/6/3 15:06
     */
    public static QueryBuilder getQueryBuilder(AbstractBaseCondition obj){
        currentLogicalExpression = "";
        //查询对象
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        //不同level之间的operator
        Map<Integer, OperatorType> difLevelOperatorMap = AbstractBaseCondition.difLevelOperatorMap;
        //获取包含父类的所有Field
        List<Field> declaredFields = ReflectUtil.getDeclaredFields(obj.getClass());
        //key为level，value为当前level的所有field值
        Map<Integer,List<Field>> levelFieldMap = new HashMap<>();
        //先遍历一遍确定层级关系，得到levelFieldMap
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Search.class)){
                int level = field.getAnnotation(Search.class).level();
                if (CollectionUtils.isEmpty(levelFieldMap.get(level))){
                    //当前level不存在就新建一个listll
                    List<Field> fields = new ArrayList<>();
                    fields.add(field);
                    levelFieldMap.put(level,fields);
                }else {
                    //存在level就在原集合上加上field
                    levelFieldMap.get(level).add(field);
                }
            }
        }
        //keySet为所有level的集合
        Set<Integer> keySet = levelFieldMap.keySet();

        //不存在Search注解的，直接返回为空
        if (CollectionUtils.isEmpty(keySet)){
            logger.info("不存在Search注解,objClassName:{}",obj.getClass().getName());
            return null;
        }
        //对key进行从大到小排序,降序
        Set<Integer> levelSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2){
                    return 1;
                }else if(o1 > o2){
                    return -1;
                }
                return 0;
            }
        });
        levelSet.addAll(keySet);
        for (Integer level : levelSet) {
            List<Field> fields = levelFieldMap.get(level);
            //得到同一个level的query
            QueryBuilder oneLevelQueryBuilder = oneLevelQueryBuilder(fields, obj);
            //将同一个level的query拼接到查询语句上
            OperatorType operator = difLevelOperatorMap.get(level);
            if (OperatorType.Must.equals(operator)) {
                queryBuilder.must(oneLevelQueryBuilder);
                currentLogicalExpression = "and" + currentLogicalExpression;
            } else if (OperatorType.Should.equals(operator)) {
                queryBuilder.should(oneLevelQueryBuilder);
                currentLogicalExpression = "or" + currentLogicalExpression;
            } else if (OperatorType.MustNot.equals(operator)) {
                queryBuilder.mustNot(oneLevelQueryBuilder);
                currentLogicalExpression = "and not" + currentLogicalExpression;
            } else if (OperatorType.Filter.equals(operator)) {
                queryBuilder.filter(oneLevelQueryBuilder);
                currentLogicalExpression = "and" + currentLogicalExpression;
            }
        }
        String currentLogicalExpressionResult =  currentLogicalExpression.replace("( and", "");
        if (currentLogicalExpressionResult.startsWith("and")){
            currentLogicalExpressionResult = currentLogicalExpressionResult.substring(3, currentLogicalExpressionResult.length() - 1);
        }
        logger.info("currentLogicalExpressionResult:{}", currentLogicalExpressionResult);
        return queryBuilder;

    }
    
    /**
     * 得到单层拼接而来的query
     * @param fields 当前层级的所有field
     * @param obj 筛选条件对象
     * @return org.elasticsearch.index.query.QueryBuilder 
     * @create 2021/6/3 9:26
     */
    private static QueryBuilder oneLevelQueryBuilder(List<Field> fields , Object obj){
        //查询对象
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        //判断当前层级的field是否有值，主要为了后续逻辑表达式输出
        Boolean hasValue = false;
        //遍历
        for (Field field : fields) {
            if (field.isAnnotationPresent(Search.class)){
                //fieldValue为筛选条件标注注解的字段值
                String fieldValue = ReflectUtil.getFieldValue(field, obj);
                //为空的话不需要进行条件查询，相当于mybatis     <if test=" != null and  != ''">
                if (!StringUtil.isEmpty(fieldValue)){
                    hasValue = true;
                    Search searchAnnotation = field.getAnnotation(Search.class);
                    //operator相当于mysql的and 或者or
                    OperatorType operator = searchAnnotation.operator();
                    //esFieldName为Es实体类对应的属性名
                    String esFieldName = searchAnnotation.fieldName();
                    //如果fieldName没赋值,说明es实体类的fieldName和筛选条件的fieldName相同
                    if (StringUtil.isEmpty(esFieldName)){
                        esFieldName = field.getName();
                    }
                    //boolType该查询条件是范围查找还是精确查找还是模糊查询
                    BoolType boolType = searchAnnotation.boolType();
                    //精确匹配的情况
                    if (BoolType.Term.equals(boolType)){
                        getTermQuery(queryBuilder,operator,esFieldName,fieldValue);
                    }
                    //范围查询的情况
                    if (BoolType.Range.equals(boolType)){
                        BoundType boundType = searchAnnotation.bound();
                        getRangeQuery(queryBuilder,operator,esFieldName,fieldValue,boundType);
                    }
                    //模糊查询的情况
                    if (BoolType.WildCard.equals(boolType)){
                        DirectionType directionType = searchAnnotation.direction();
                        getWildCardQuery(queryBuilder,operator,esFieldName,fieldValue,directionType);
                    }
                }
            }else {
                logger.info("fieldName:{},不存在Search",field.getName());
            }
        }
        if (hasValue){
            currentLogicalExpression = "("+ currentLogicalExpression +")";
        }
        return queryBuilder;
    }

    /**
     * 将模糊查询的query拼接上
     * @param queryBuilder 查询对象
     * @param operator 相当于mysql的and 或者or
     * @param esFieldName Es实体类对应的属性名
     * @param fieldValue 筛选条件标注注解的字段值
     * @param directionType 模糊类型，左右模糊，全模糊
     * @return void
     * @create 2021/6/3 11:07
     */
    private static void getWildCardQuery(BoolQueryBuilder queryBuilder, OperatorType operator, String esFieldName, String fieldValue, DirectionType directionType) {
        /**
         * match:根据定义的分词器（默认standard）对搜索词进行拆分，根据拆分结果逐个进行匹配。特点是可以查出大量可能相关联的数据，但是准确率低。
         * match_phrase:短语匹配，同样会对搜索词拆分，但是所有拆分结果都必须包含，并且顺序一致，中间没有插入其他词语。特点是准确率高，但是最终匹配结果集较小。
         * wildcard:通配符模式的模糊匹配，使用简单，但是性能较慢。
         * 支持以下2种通配符：
         *
         * ?，匹配一个字符
         * *，匹配零个或多个字符
         * 官方建议：
         * 尽量避免在开头加通配符 ? 或者 *，这样会明显降低查询性能
         */
        if (OperatorType.Must.equals(operator)){
            if (DirectionType.All.equals(directionType)){
                queryBuilder.must(QueryBuilders.wildcardQuery(esFieldName+".keyword","*"+fieldValue+"*"));
            }
            if (DirectionType.Left.equals(directionType)){
                queryBuilder.must(QueryBuilders.wildcardQuery(esFieldName+".keyword","*"+fieldValue));
            }
            if (DirectionType.Right.equals(directionType)){
                queryBuilder.must(QueryBuilders.wildcardQuery(esFieldName+".keyword",fieldValue+"*"));
            }
        }
        if (OperatorType.Should.equals(operator)){
            if (DirectionType.All.equals(directionType)){
                queryBuilder.should(QueryBuilders.wildcardQuery(esFieldName+".keyword","*"+fieldValue+"*"));
            }
            if (DirectionType.Left.equals(directionType)){
                queryBuilder.should(QueryBuilders.wildcardQuery(esFieldName+".keyword","*"+fieldValue));
            }
            if (DirectionType.Right.equals(directionType)){
                queryBuilder.should(QueryBuilders.wildcardQuery(esFieldName+".keyword",fieldValue+"*"));
            }
        }
        if (OperatorType.MustNot.equals(operator)){
            if (DirectionType.All.equals(directionType)){
                queryBuilder.mustNot(QueryBuilders.wildcardQuery(esFieldName+".keyword","*"+fieldValue+"*"));
            }
            if (DirectionType.Left.equals(directionType)){
                queryBuilder.mustNot(QueryBuilders.wildcardQuery(esFieldName+".keyword","*"+fieldValue));
            }
            if (DirectionType.Right.equals(directionType)){
                queryBuilder.mustNot(QueryBuilders.wildcardQuery(esFieldName+".keyword",fieldValue+"*"));
            }
        }
        if (OperatorType.Filter.equals(operator)){
            if (DirectionType.All.equals(directionType)){
                queryBuilder.filter(QueryBuilders.wildcardQuery(esFieldName+".keyword","*"+fieldValue+"*"));
            }
            if (DirectionType.Left.equals(directionType)){
                queryBuilder.filter(QueryBuilders.wildcardQuery(esFieldName+".keyword","*"+fieldValue));
            }
            if (DirectionType.Right.equals(directionType)){
                queryBuilder.filter(QueryBuilders.wildcardQuery(esFieldName+".keyword",fieldValue+"*"));
            }
        }
        currentLogicalExpression = appendCurrentLogicalExpression(currentLogicalExpression , esFieldName , fieldValue
                , BoolType.WildCard , null , directionType, operator).toString();
    }

    /**
     * 将范围查找的query拼接上
     * @param queryBuilder 查询对象
     * @param operator 相当于mysql的and 或者or
     * @param esFieldName Es实体类对应的属性名
     * @param fieldValue 筛选条件标注注解的字段值
     * @param boundType 上下界标注
     * @return void 
     * @create 2021/6/3 10:15
     */
    private static void getRangeQuery(BoolQueryBuilder queryBuilder, OperatorType operator, String esFieldName, String fieldValue ,BoundType boundType) {
        /**
         * eq 就是 EQUAL等于
         * neq就是 NOT EQUAL不等于
         * gt 就是 GREATER THAN大于　
         * lt就是 LESS THAN小于
         * gte就是 GREATER THAN OR EQUAL 大于等于
         * lte 就是 LESS THAN OR EQUAL 小于等于
         */
        if (OperatorType.Must.equals(operator)){
            if (BoundType.Start.equals(boundType)){
                //start表示下界，大于等于
                queryBuilder.must(QueryBuilders.rangeQuery(esFieldName).gte(fieldValue));
            }
            if (BoundType.End.equals(boundType)){
                //end表示上界，小于
                queryBuilder.must(QueryBuilders.rangeQuery(esFieldName).lt(fieldValue));
            }
        }else if (OperatorType.Should.equals(operator)){
            if (BoundType.Start.equals(boundType)){
                //start表示下界，大于等于
                queryBuilder.should(QueryBuilders.rangeQuery(esFieldName).gte(fieldValue));
            }
            if (BoundType.End.equals(boundType)){
                //end表示上界，小于
                queryBuilder.should(QueryBuilders.rangeQuery(esFieldName).lt(fieldValue));
            }
        }else if (OperatorType.MustNot.equals(operator)){
            if (BoundType.Start.equals(boundType)){
                //start表示下界，大于等于
                queryBuilder.mustNot(QueryBuilders.rangeQuery(esFieldName).gte(fieldValue));
            }
            if (BoundType.End.equals(boundType)){
                //end表示上界，小于
                queryBuilder.mustNot(QueryBuilders.rangeQuery(esFieldName).lt(fieldValue));
            }
        }else if (OperatorType.Filter.equals(operator)){
            if (BoundType.Start.equals(boundType)){
                //start表示下界，大于等于
                queryBuilder.filter(QueryBuilders.rangeQuery(esFieldName).gte(fieldValue));
            }
            if (BoundType.End.equals(boundType)){
                //end表示上界，小于
                queryBuilder.filter(QueryBuilders.rangeQuery(esFieldName).lt(fieldValue));
            }
        }
        currentLogicalExpression = appendCurrentLogicalExpression(currentLogicalExpression , esFieldName , fieldValue
                , BoolType.Range , boundType , null, operator).toString();
    }

    /**
     * 将精确查询的query拼接上
     * @param queryBuilder 查询对象
     * @param operator 相当于mysql的and 或者or
     * @param esFieldName Es实体类对应的属性名
     * @param fieldValue 筛选条件标注注解的字段值
     * @return void
     * @create 2021/6/3 10:11
     */
    private static void getTermQuery(BoolQueryBuilder queryBuilder, OperatorType operator, String esFieldName, String fieldValue) {
        if (OperatorType.Must.equals(operator)){
            //对于termQuery的描述官网 https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl-term-query.html
            //term是代表完全匹配，即不进行分词器分析，文档中必须包含整个搜索的词汇,建议精确匹配的设置为keyword
            queryBuilder.must(QueryBuilders.termQuery(esFieldName+".keyword",fieldValue));
        }else if (OperatorType.Should.equals(operator)){
            queryBuilder.should(QueryBuilders.termQuery(esFieldName+".keyword",fieldValue));
        }else if (OperatorType.MustNot.equals(operator)){
            queryBuilder.mustNot(QueryBuilders.termQuery(esFieldName+".keyword",fieldValue));
        }else if (OperatorType.Filter.equals(operator)){
            queryBuilder.filter(QueryBuilders.termQuery(esFieldName+".keyword",fieldValue));
        }
        currentLogicalExpression = appendCurrentLogicalExpression(currentLogicalExpression , esFieldName , fieldValue
                , BoolType.Term , null , null, operator).toString();
    }

    public static StringBuilder appendCurrentLogicalExpression(String currentLogicalExpression , String fieldName , String fieldValue
            , BoolType boolType , BoundType boundType , DirectionType directionType , OperatorType operatorType){
        StringBuilder stringBuilder = new StringBuilder(currentLogicalExpression)
                .append(operatorExpressionMap.get(operatorType))
                .append(fieldName);
        if (BoolType.Term.equals(boolType)){
            stringBuilder.append(boolExpressionMap.get(boolType))
                    .append(fieldValue);
        }
        if (BoolType.Range.equals(boolType)){
            stringBuilder.append(boundExpressionMap.get(boundType))
                    .append(fieldValue);
        }
        if (BoolType.WildCard.equals(boolType)){
            stringBuilder.append(boolExpressionMap.get(boolType));
            if (!DirectionType.Right.equals(directionType)){
                stringBuilder.append("*");
            }
            stringBuilder.append(fieldValue);
            if (!DirectionType.Left.equals(directionType)){
                stringBuilder.append("*");
            }
        }
        return stringBuilder;
    }


}
