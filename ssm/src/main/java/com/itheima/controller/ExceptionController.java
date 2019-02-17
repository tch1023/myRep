package com.itheima.controller;

import com.itheima.domain.SysException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 * @Author: tch
 * @Date: 2019/2/14 下午 02:48
 */
public class ExceptionController implements HandlerExceptionResolver {
    /**
     * 跳转到具体错误页面的方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //打印错误信息
        e.printStackTrace();
        //创建自定义异常类
        SysException ex = null;
        if(e instanceof SysException){
            ex = (SysException)e;
        }else {
            ex = new SysException("请联系童晨浩");
        }
        ModelAndView modelAndView = new ModelAndView();
        //存入错误信息
        modelAndView.addObject("errorMsg",ex.getMessage());
        //跳转页面jsp
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
