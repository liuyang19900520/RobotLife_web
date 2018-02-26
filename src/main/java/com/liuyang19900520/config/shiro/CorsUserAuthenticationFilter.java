package com.liuyang19900520.config.shiro;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by liuyang on 2018/2/26
 */
@Component
public class CorsUserAuthenticationFilter extends UserFilter{
    /**
     * 不过滤OPTIONS方法
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            return true;
        }

        return super.isAccessAllowed(request, response, mappedValue);
    }
}
