package com.github.cloud.netflix.zuul.filters.pre;

import com.github.cloud.netflix.zuul.filters.RouteLocator;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:  pre类型过滤器，根据RouteLocator来进行路由规则的匹配
 * @date 2024/8/11 18:31
 */
public class PreDecorationFilter extends ZuulFilter {
    private RouteLocator routeLocator;

    public PreDecorationFilter(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
