package com.swjd.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUri=request.getRequestURI();//获取请求地址
        //如果是登陆页面就放行
        if (requestUri.indexOf("login")>=0||requestUri.indexOf("Login")>=0||requestUri.indexOf("Main")>=0){
            return true;
        }
        //如果用户登陆过
        HttpSession session=request.getSession();//获取session
        if (session.getAttribute("activeName")!=null){
            return true;
        }

        //不放行并且需要回到登陆页面
        request.getRequestDispatcher("/toLogin").forward(request,response);


        return false;
    }
}
