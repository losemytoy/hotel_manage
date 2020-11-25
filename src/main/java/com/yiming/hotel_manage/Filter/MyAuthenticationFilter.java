package com.yiming.hotel_manage.Filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyAuthenticationFilter extends FormAuthenticationFilter {

    private static final String USR_LOGIN_URL = "/login/user_login";
    private static final String ADMIN_LOGIN_URL = "/login/admin_login";


//    shiro底层是通过redirectToLogin方法使未认证的用户跳转到登陆页的，那么只需要重写这个方法即可。
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();

        if(url.contains("/user"))
            WebUtils.issueRedirect(request, response, USR_LOGIN_URL);
        else if(url.contains("/admin"))
            WebUtils.issueRedirect(request, response, ADMIN_LOGIN_URL);
    }

}
