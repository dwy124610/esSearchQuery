package com.dwy.es.enums;

/**参考网站：https://zhuanlan.zhihu.com/p/161710475
 * @Author: DongWenYu
 * @Date: 2021/6/3 9:40
 */
public enum OperatorType {

    /**
     * 相当于mysql and,必须匹配，贡献算分，属于Query
     */
    Must,

    /**
     * 相当于mysql or，选择性匹配，贡献算分,属于Query
     */
    Should,

    /**
     * Must的否定，查询字句，必须不能匹配，不贡献算分，属于Filter
     */
    MustNot,

    /**
     * 过滤，必须匹配，不贡献算分，会使用缓存，速度快,属于Filter
     */
    Filter;
    private OperatorType(){
    }
}
