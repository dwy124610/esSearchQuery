package com.dwy.es.esrepository;

import com.dwy.es.esdomain.EsDataClueDemand;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/3 14:12
 */
public interface EsDataClueDemandrepository extends ElasticsearchRepository<EsDataClueDemand,Long> {
}
