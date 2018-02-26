package com.liuyang19900520.config.shiro;

import com.liuyang19900520.service.SUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Component
public class URLPermissionsFilter extends PermissionsAuthorizationFilter {

    @Autowired
    private SUserService userService;

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws IOException {

        String curUrl = getRequestUrl(request);
        Subject subject = SecurityUtils.getSubject();
        HttpServletRequest httpRequest = WebUtils.toHttp(request);

        if (subject.getPrincipal() == null || StringUtils.endsWithAny(curUrl, ".min.js", ".min.css", ".js", ".css", ".html", "ftl")||
                StringUtils.contains(curUrl,"woff")
                || StringUtils.endsWithAny(curUrl, ".jpg", ".png", ".gif", ".jpeg")
                || StringUtils.equals(curUrl, "/unauthor")) {
            return true;
        }
        List<String> urls = userService.findPermissionUrl(subject.getPrincipal().toString());
        return urls.contains(curUrl);
    }

    /**
     * 获取当前URL+Parameter
     *
     * @param request 拦截请求request
     * @return 返回完整URL
     * @author lance
     * @since 2014年12月18日 下午3:09:26
     */
    private String getRequestUrl(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest) request;
        String queryString = req.getQueryString();

        queryString = StringUtils.isBlank(queryString) ? "" : "?" + queryString;
        return req.getRequestURI() + queryString;
    }

}
