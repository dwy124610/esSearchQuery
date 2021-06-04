package com.dwy.es.enums;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/2 10:53
 */
public enum BoolType {
    /**
     * 范围查询
     */
    Range,
    /**
     * 精确查询，建议实体类上标注为keyword
     */
    Term,
    /**
     * 模糊查询，建议实体类上标注为text
     */
    WildCard;

    private BoolType(){
    }

}
