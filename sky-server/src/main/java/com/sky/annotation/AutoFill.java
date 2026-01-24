package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;//自定义注解，用于公共字段处理
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
//数据库操作类型，引用枚举包（update，insert
    OperationType value();

}
