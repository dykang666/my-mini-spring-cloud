package com.github.cloud.tutu.registry;

import com.github.cloud.tutu.TutuDiscoveryProperties;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.serviceregistry.Registration;

import java.net.URI;
import java.util.Map;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:  登记接口
 * @date 2024/8/10 16:22
 */
public class TutuRegistration implements Registration {

    private TutuDiscoveryProperties tutuDiscoveryProperties;

    public TutuRegistration(TutuDiscoveryProperties tutuDiscoveryProperties) {
        this.tutuDiscoveryProperties = tutuDiscoveryProperties;
    }


    @Override
    public String getServiceId() {
        return tutuDiscoveryProperties.getService();
    }

    @Override
    public String getHost() {
        return tutuDiscoveryProperties.getIp();
    }

    @Override
    public int getPort() {
        return tutuDiscoveryProperties.getPort();
    }

    @Override
    public boolean isSecure() {
        return tutuDiscoveryProperties.isSecure();
    }

    @Override
    public URI getUri() {
        return DefaultServiceInstance.getUri(this);
    }

    @Override
    public Map<String, String> getMetadata() {
        return null;
    }
    public void setPort(int port) {
        this.tutuDiscoveryProperties.setPort(port);
    }

    public TutuDiscoveryProperties getTutuDiscoveryProperties() {
        return tutuDiscoveryProperties;
    }
}
