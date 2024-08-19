package com.github.cloud.loadbalancer.ribbon;

import com.netflix.loadbalancer.Server;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: 服务实例
 * @date 2024/8/10 22:05
 */
public class TutuServer extends Server {

    public TutuServer(String host, int port) {
        super(host, port);
    }
}
