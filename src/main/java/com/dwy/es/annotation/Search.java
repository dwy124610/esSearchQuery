package com.dwy.es.annotation;

import com.dwy.es.enums.BoolType;
import com.dwy.es.enums.BoundType;
import com.dwy.es.enums.DirectionType;
import com.dwy.es.enums.OperatorType;

import java.lang.annotation.*;

/**查询注解，标注在筛选条件字段上
 * 范围查询关注:bound
 * 模糊查询关注:direction
 * @Author: DongWenYu
 * @Date: 2021/5/27 9:31
 */
@Retention(RetentionPolicy.RUNTIME)//元注解，定义注解被保留策略，一般有三种策略
//1、RetentionPolicy.SOURCE 注解只保留在源文件中，在编译成class文件的时候被遗弃
//2、RetentionPolicy.CLASS 注解被保留在class中，但是在jvm加载的时候抛弃，这个是默认的声明周期
//3、RetentionPolicy.RUNTIME 注解在jvm加载的时候仍被保留
@Target(ElementType.FIELD)
@Documented
public @interface Search {
    /**
     * 对应实体类的字段
     * @return
     */
    public String fieldName() default "";

    /**
     * 逻辑运算符:example:must,should。
     * 同层级的
     * @return
     */
    public OperatorType operator() default OperatorType.Must;

    /**
     * 模糊方向:example:left,right,all
     * @return
     */
    public DirectionType direction() default DirectionType.All;

    /**
     * 组合层级，默认0，越大优先组合越高
     * @return
     */
    public int level() default 0;

    /**
     * Term:精确查询
     * Wildcard:模糊查询
     * Range:范围查询
     * @return
     */
    public BoolType boolType() default BoolType.Term;

    /**
     * 是上界还是下界,example:start,end
     * @return
     */
    public BoundType bound() default BoundType.Start;
}
