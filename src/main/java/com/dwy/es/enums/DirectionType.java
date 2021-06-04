package com.dwy.es.enums;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/3 9:44
 */
public enum DirectionType {

    /**
     * 左模糊，相当于mysql *#{value}
     */
    Left,

    /**
     * 右模糊，相当于mysql #{value}*
     */
    Right,

    /**
     * 全模糊，相当于mysql *#{value}*
     */
    All;

    private DirectionType(){
    }
}
