package com.dwy.es;

import com.dwy.es.model.DemandQueryCondition;
import com.dwy.es.util.QueryBuilderUtil;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/3 12:54
 */
public class QueryBuilderUtilTest {

    @Test
    public void getQueryBuilderTest(){
        DemandQueryCondition demandQueryCondition = new DemandQueryCondition();
        demandQueryCondition.setPurpose("生产");
        demandQueryCondition.setEnterpriseName("四川");
        demandQueryCondition.setProvince("123");
        demandQueryCondition.setCity("456");
        QueryBuilder queryBuilder = QueryBuilderUtil.getQueryBuilder(demandQueryCondition);
        Pageable pageable = PageRequest.of(0 , 10);
        //构建查询
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withSort(SortBuilders.fieldSort("allocationStatus.keyword").order(SortOrder.ASC).unmappedType("string"))
                .withSort(SortBuilders.fieldSort("operationStatus.keyword").order(SortOrder.ASC).unmappedType("string"))
                .withSort(SortBuilders.fieldSort("establishDateSort.keyword").order(SortOrder.ASC).unmappedType("long"))
                .withSort(SortBuilders.fieldSort("enterpriseNameInitials.keyword").order(SortOrder.ASC).unmappedType("string"))
                //.addAggregation(builder)
                .withPageable(pageable)
                .build();
        System.out.println(query);
        System.out.println(demandQueryCondition.getLogicalExpression());
    }
}
