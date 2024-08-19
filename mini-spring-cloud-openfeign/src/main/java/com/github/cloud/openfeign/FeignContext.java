package com.github.cloud.openfeign;

import org.springframework.cloud.context.named.NamedContextFactory;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:   为每个feign客户端创建一个应用上下文(ApplicationContext)，隔离每个feign客户端的配置
 * @date 2024/8/11 17:02
 */
public class FeignContext extends NamedContextFactory<FeignClientSpecification> {
    public FeignContext() {
        super(FeignClientsConfiguration.class, "feign", "feign.client.name");
    }
}
