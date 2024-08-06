package com.lanqiao.zzy.AOP;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ModelAndView exceptionHandler(ModelMap model,Exception e){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exceptionMessage", e.getMessage());
        System.out.println("in testControllerAdvice");
        return mv;
    }

}
