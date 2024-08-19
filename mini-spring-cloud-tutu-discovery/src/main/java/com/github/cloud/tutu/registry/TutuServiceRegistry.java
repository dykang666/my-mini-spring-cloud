package com.github.cloud.tutu.registry;

import cn.hutool.http.HttpUtil;
import com.github.cloud.tutu.TutuDiscoveryProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: 具体的服务注册实现类
 * @date 2024/8/10 16:54
 */
@Slf4j
public class TutuServiceRegistry  implements ServiceRegistry<Registration> {
    private TutuDiscoveryProperties tutuDiscoveryProperties;

    public TutuServiceRegistry(TutuDiscoveryProperties tutuDiscoveryProperties) {
        this.tutuDiscoveryProperties = tutuDiscoveryProperties;
    }

    /**
     * 注册服务实例
     *
     * @param registration
     */

    @Override
    public void register(Registration registration) {
        Map<String, Object> param = new HashMap<>();
        param.put("serviceName", tutuDiscoveryProperties.getService());
        param.put("ip", tutuDiscoveryProperties.getIp());
        param.put("port", tutuDiscoveryProperties.getPort());
        String result = HttpUtil.post(tutuDiscoveryProperties.getServerAddr() + "/register", param);
        if (Boolean.parseBoolean(result)) {
            log.info("register service successfully, serviceName: {}, ip: {}, port: {}",
                    tutuDiscoveryProperties.getService(), tutuDiscoveryProperties.getIp(), tutuDiscoveryProperties.getPort());
        } else {
            log.error("register service failed, serviceName: {}, ip: {}, port: {}",
                    tutuDiscoveryProperties.getService(), tutuDiscoveryProperties.getIp(), tutuDiscoveryProperties.getPort());
            throw new RuntimeException("register service failed, serviceName");
        }



    }


    /**
     * 注销服务实例
     *
     * @param registration
     */
    @Override
    public void deregister(Registration registration) {
        Map<String, Object> param = new HashMap<>();
        param.put("serviceName", tutuDiscoveryProperties.getService());
        param.put("ip", tutuDiscoveryProperties.getIp());
        param.put("port", tutuDiscoveryProperties.getPort());
        String result = HttpUtil.post(tutuDiscoveryProperties.getServerAddr() + "/deregister", param);
        if (Boolean.parseBoolean(result)) {
            log.info("de-register service successfully, serviceName: {}, ip: {}, port: {}",
                    tutuDiscoveryProperties.getService(), tutuDiscoveryProperties.getIp(), tutuDiscoveryProperties.getPort());
        } else {
            log.warn("de-register service failed, serviceName: {}, ip: {}, port: {}",
                    tutuDiscoveryProperties.getService(), tutuDiscoveryProperties.getIp(), tutuDiscoveryProperties.getPort());
        }
    }

    @Override
    public void close() {

    }

    @Override
    public void setStatus(Registration registration, String status) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T getStatus(Registration registration) {
        return null;
    }
}
