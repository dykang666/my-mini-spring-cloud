package com.github.cloud.openfeign.ribbon;

import feign.Client;
import feign.Request;
import feign.Response;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * 具备负载均衡能力的feign client
 * @date 2024/8/11 17:11
 */
public class LoadBalancerFeignClient implements Client {
    private LoadBalancerClient loadBalancerClient;

    private Client delegate;
    public LoadBalancerFeignClient(LoadBalancerClient loadBalancerClient, Client delegate) {
        this.loadBalancerClient = loadBalancerClient;
        this.delegate = delegate;
    }
    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        //客户端负载均衡
        try {
            URI original = URI.create(request.url());
            String serviceId = original.getHost();
            //选择服务实例
            ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
            //重建请求URI
            URI uri = loadBalancerClient.reconstructURI(serviceInstance, original);
            Request newRequest = Request.create(request.httpMethod(), uri.toASCIIString(), new HashMap<>(),
                    request.body(), StandardCharsets.UTF_8);
            return delegate.execute(newRequest, options);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
