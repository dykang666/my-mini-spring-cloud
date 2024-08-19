package com.github.cloud.netflix.zuul.filters.post;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:  post类型过滤器，向客户端输出响应报文
 * @date 2024/8/11 18:40
 */
@Slf4j
public class SendResponseFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1000;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext()
                .getResponseDataStream() != null;
    }

    @Override
    public Object run() throws ZuulException {
        //向客户端输出响应报文
        RequestContext requestContext = RequestContext.getCurrentContext();
        InputStream inputStream = requestContext.getResponseDataStream();
        try {
            HttpServletResponse servletResponse = requestContext.getResponse();
            servletResponse.setCharacterEncoding("UTF-8");

            OutputStream outStream = servletResponse.getOutputStream();
            StreamUtils.copy(inputStream, outStream);
        } catch (Exception e) {
            rethrowRuntimeException(e);
        } finally {
            //关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    log.error("关闭输入流失败", e);
                }
            }

            //Servlet容器会自动关闭输出流
        }
        return null;
    }
}
