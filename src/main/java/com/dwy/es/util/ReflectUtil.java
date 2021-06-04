package com.dwy.es.util;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/2 17:50
 */
public class ReflectUtil {

    //类属性转get方法名
    public static String getMethodName(String propertyName) {
        String methodEnd = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        methodEnd="get"+methodEnd;
        return methodEnd;
    }

    //获取包含父类的所有Field
    public static List<Field> getDeclaredFields(Class clazz) {
        List<Field> fields = new ArrayList<>();
        while (!Object.class.equals(clazz)) {
            fields.addAll(Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    //获取Field的值
    public static String getFieldValue(Field field, Object obj) {
        Class<?> clazz = obj.getClass();
        if (field == null) {
            return null;
        }
        ReflectionUtils.makeAccessible(field);
        String methodName = ReflectUtil.getMethodName(field.getName());//获得get方法
        try {
            Method getMethod = clazz.getMethod(methodName);
            String result =  getMethod.invoke(obj, new Object[]{}) + "";
            if ("null".equals(result)){
                return null;
            }else {
                return result;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
