package com.github.cloud.netflix.zuul.filters;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: 路由
 * @date 2024/8/11 18:23
 */
public class Route {
    private String path;

    private String location;

    public Route(String path, String location) {
        this.path = path;
        this.location = location;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
