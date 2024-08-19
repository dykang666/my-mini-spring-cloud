package com.github.cloud.loadbalancer.ribbon;

import org.springframework.cloud.context.named.NamedContextFactory;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:  ribbon客户端配置
 * @date 2024/8/10 22:17
 */
public class RibbonClientSpecification  implements NamedContextFactory.Specification{



    private String name;

    private Class<?>[] configuration;

    public RibbonClientSpecification() {
    }
    public RibbonClientSpecification(String name, Class<?>[] configuration) {
        this.name = name;
        this.configuration = configuration;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<?>[] getConfiguration() {
        return configuration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfiguration(Class<?>[] configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RibbonClientSpecification that = (RibbonClientSpecification) o;
        return Arrays.equals(configuration, that.configuration)
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configuration, name);
    }

    @Override
    public String toString() {
        return new StringBuilder("RibbonClientSpecification{").append("name='")
                .append(name).append("', ").append("configuration=")
                .append(Arrays.toString(configuration)).append("}").toString();
    }
}
