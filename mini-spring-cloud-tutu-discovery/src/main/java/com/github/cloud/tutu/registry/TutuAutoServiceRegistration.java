package com.github.cloud.tutu.registry;

import org.springframework.cloud.client.serviceregistry.AbstractAutoServiceRegistration;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: 服务自动注册
 * @date 2024/8/10 17:04
 */
public class TutuAutoServiceRegistration extends AbstractAutoServiceRegistration<Registration> {

    private TutuRegistration tutuRegistration;

    protected TutuAutoServiceRegistration(ServiceRegistry<Registration> serviceRegistry,TutuRegistration tutuRegistration) {
        super(serviceRegistry, null);
        this.tutuRegistration = tutuRegistration;
    }
    @Override
    protected Registration getRegistration() {
        if (tutuRegistration.getPort() < 0) {
            //设置服务端口
            tutuRegistration.setPort(this.getPort().get());
        }
        return tutuRegistration;
    }
    @Override
    protected Object getConfiguration() {
        return tutuRegistration.getTutuDiscoveryProperties();
    }

    @Override
    protected boolean isEnabled() {
        return true;
    }



    @Override
    protected Registration getManagementRegistration() {
        return null;
    }
}
