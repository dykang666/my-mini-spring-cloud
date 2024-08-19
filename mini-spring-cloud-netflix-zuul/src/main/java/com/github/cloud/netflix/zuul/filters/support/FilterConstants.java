package com.github.cloud.netflix.zuul.filters.support;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/8/11 18:33
 */
public interface FilterConstants {
    String REQUEST_URI_KEY = "requestURI";

    String SERVICE_ID_KEY = "serviceId";


    //过滤器类型常量-----------------------------------
    String PRE_TYPE = "pre";

    String ROUTE_TYPE = "route";

    String POST_TYPE = "post";

    String ERROR_TYPE = "error";

}
