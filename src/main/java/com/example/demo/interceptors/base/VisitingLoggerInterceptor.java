package com.example.demo.interceptors.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fanhuijie
 * @date 2021/2/23
 * @desc
 */
@Slf4j
public class VisitingLoggerInterceptor implements HandlerInterceptor {
    String template = "%s end,%s,%s";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(request.getRequestURI() + " start");
//        log.info("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.info("afterCompletion");
//        url,interceptorsExecuteCost,controllerExecuteCost
        log.info(String.format(template, request.getRequestURI(), request.getAttribute("interceptorsExecuteCost"), request.getAttribute("controllerExecuteCost")));
    }
}
