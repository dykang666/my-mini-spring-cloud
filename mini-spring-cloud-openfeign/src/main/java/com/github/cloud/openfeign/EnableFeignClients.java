package com.github.cloud.openfeign;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:  启用Feign
 * @date 2024/8/11 16:46
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(FeignClientsRegistrar.class)
public @interface EnableFeignClients {
}
