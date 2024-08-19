package com.github.cloud.openfeign.support;

import feign.Contract;
import feign.MethodMetadata;
import feign.Request;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 *  feign支持Spring MVC的注解
 * @date 2024/8/11 17:08
 */
public class SpringMvcContract extends Contract.BaseContract {
    @Override
    protected void processAnnotationOnClass(MethodMetadata methodMetadata, Class<?> aClass) {
        //TODO 解析接口注解
    }

    @Override
    protected void processAnnotationOnMethod(MethodMetadata methodMetadata, Annotation annotation, Method method) {
        //解析方法注解
        //解析PostMapping注解
        if (annotation instanceof PostMapping) {
            PostMapping postMapping = (PostMapping) annotation;
            methodMetadata.template().method(Request.HttpMethod.POST);
            String path = postMapping.value()[0];
            if (!path.startsWith("/") && !methodMetadata.template().path().endsWith("/")) {
                path = "/" + path;
            }
            methodMetadata.template().uri(path, true);
        }
        //TODO 解析其他注解
    }

    @Override
    protected boolean processAnnotationsOnParameter(MethodMetadata methodMetadata, Annotation[] annotations, int i) {
        //TODO 解析参数
        return true;
    }
}
