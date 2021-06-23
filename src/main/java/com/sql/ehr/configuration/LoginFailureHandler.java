package com.sql.ehr.configuration;

import com.alibaba.fastjson.JSON;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义认证失败处理类
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        returnFailure(httpServletResponse,e);
    }
    public void returnFailure(HttpServletResponse response, AuthenticationException e) throws IOException{
        System.out.println("认证失败");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e==null?"认证失败":e.getMessage());
    }
}