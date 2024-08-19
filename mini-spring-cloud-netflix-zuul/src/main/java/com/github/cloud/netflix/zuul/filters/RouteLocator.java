package com.github.cloud.netflix.zuul.filters;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: 路由定位器
 * @date 2024/8/11 18:22
 */
public interface RouteLocator {

    /**
     * 获取匹配的路由
     *
     * @param path
     * @return
     */
    Route getMatchingRoute(String path);
}
