package com.github.cloud.loadbalancer.ribbon.config;

import com.github.cloud.loadbalancer.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/8/10 22:11
 */
@Configuration
@RibbonClients(defaultConfiguration = TutuRibbonClientConfiguration.class)
public class RibbonTutuAutoConfiguration {
}
