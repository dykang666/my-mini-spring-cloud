package com.github.cloud.examples;

import com.github.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/8/11 17:23
 */
@FeignClient("provider-application")
public interface EchoService {
    @PostMapping("echo")
    String echo();
}
