package com.dwy.es.metadata;

import com.dwy.es.annotation.Search;
import com.dwy.es.enums.BoolType;
import com.dwy.es.enums.BoundType;
import com.dwy.es.enums.DirectionType;
import com.dwy.es.enums.OperatorType;
import com.dwy.es.util.QueryBuilderUtil;
import com.dwy.es.util.ReflectUtil;
import com.dwy.es.util.StringUtil;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 所有查询对象都需要继承这个类
 *
 * @Author: DongWenYu
 * @Date: 2021/6/3 11:46
 */
public abstract class AbstractBaseCondition {

    //不同level之间的operator
    public static Map<Integer, OperatorType> difLevelOperatorMap = new HashMap<>();

    private static String logicalExpression = "";

    /**
     * 设置不同level之间的operator
     *
     * @return void
     * @create 2021/6/3 11:51
     */
    public abstract void setDifLevelOperatorType();

    public AbstractBaseCondition() {
        setDifLevelOperatorType();
        setLogicalExpression();
    }

    /**
     * 得到当前对象的逻辑表达式
     * 主要目的是为了验证注解的正确性，全部作为条件，没有值的用？表示，有默认值的用默认值表示
     *
     * @return void
     * @create 2021/6/4 9:13
     */
    public void setLogicalExpression() {
        //获取包含父类的所有Field
        List<Field> declaredFields = ReflectUtil.getDeclaredFields(this.getClass());
        //key为level，value为当前level的所有field值
        Map<Integer, List<Field>> levelFieldMap = new HashMap<>();
        //先遍历一遍确定层级关系，得到levelFieldMap
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Search.class)) {
                int level = field.getAnnotation(Search.class).level();
                if (CollectionUtils.isEmpty(levelFieldMap.get(level))) {
                    //当前level不存在就新建一个listll
                    List<Field> fields = new ArrayList<>();
                    fields.add(field);
                    levelFieldMap.put(level, fields);
                } else {
                    //存在level就在原集合上加上field
                    levelFieldMap.get(level).add(field);
                }
            }
        }
        //keySet为所有level的集合
        Set<Integer> keySet = levelFieldMap.keySet();

        //对key进行从大到小排序,降序
        Set<Integer> levelSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1 > o2) {
                    return -1;
                }
                return 0;
            }
        });
        levelSet.addAll(keySet);

        for (Integer level : levelSet) {
            List<Field> fields = levelFieldMap.get(level);
            for (Field field : fields) {
                if (field.isAnnotationPresent(Search.class)) {
                    //fieldValue为筛选条件标注注解的字段值
                    String fieldValue = ReflectUtil.getFieldValue(field, this);
                    if (StringUtil.isEmpty(fieldValue)) {
                        fieldValue = "?";
                    }
                    Search searchAnnotation = field.getAnnotation(Search.class);
                    //operator相当于mysql的and 或者or
                    OperatorType operator = searchAnnotation.operator();
                    //esFieldName为Es实体类对应的属性名
                    String esFieldName = searchAnnotation.fieldName();
                    //如果fieldName没赋值,说明es实体类的fieldName和筛选条件的fieldName相同
                    if (StringUtil.isEmpty(esFieldName)) {
                        esFieldName = field.getName();
                    }
                    BoolType boolType = searchAnnotation.boolType();
                    BoundType boundType = searchAnnotation.bound();
                    DirectionType directionType = searchAnnotation.direction();
                    logicalExpression = QueryBuilderUtil.appendCurrentLogicalExpression(logicalExpression, esFieldName, fieldValue
                            , boolType, boundType, directionType, operator).toString();
                }
            }
            logicalExpression = "(" + logicalExpression +")";
            //将同一个level的query拼接到查询语句上
            OperatorType operator = difLevelOperatorMap.get(level);
            if (OperatorType.Must.equals(operator)) {
                logicalExpression = "and" + logicalExpression;
            } else if (OperatorType.Should.equals(operator)) {
                logicalExpression = "or" + logicalExpression;
            } else if (OperatorType.MustNot.equals(operator)) {
                logicalExpression = "not" + logicalExpression;
            } else if (OperatorType.Filter.equals(operator)) {
                logicalExpression = "and" + logicalExpression;
            }
        }
        String currentLogicalExpressionResult =  logicalExpression.replace("( and", "");
        if (currentLogicalExpressionResult.startsWith("and")){
            currentLogicalExpressionResult = currentLogicalExpressionResult.substring(3, currentLogicalExpressionResult.length() - 1);
        }
        logicalExpression = currentLogicalExpressionResult;
    }

    public String getLogicalExpression() {
        return logicalExpression;
    }
}
