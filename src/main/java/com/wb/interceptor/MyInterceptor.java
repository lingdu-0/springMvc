package com.wb.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override//返回 false 不会再继续执行,返回true继续往下执行
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("ip:" + httpServletRequest.getRemoteHost() + "url:" + httpServletRequest.getRequestURI());
//        httpServletResponse.setCharacterEncoding("utf-8");//过滤器
//        httpServletResponse.setContentType("text/html;charset=utf-8");
//        httpServletResponse.getWriter().println("你无权访问!");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
