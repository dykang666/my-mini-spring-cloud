package com.github.cloud.openfeign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:  自动装配
 * @date 2024/8/11 17:19
 */
@Configuration
public class FeignAutoConfiguration {
    @Bean
    public FeignContext feignContext() {
        return new FeignContext();
    }
}
