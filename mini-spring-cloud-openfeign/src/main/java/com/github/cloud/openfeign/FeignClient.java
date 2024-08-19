package com.github.cloud.openfeign;

import java.lang.annotation.*;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/8/11 16:58
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FeignClient {
    /**
     * 服务提供者应用名称
     *
     * @return
     */
    String value();
}
