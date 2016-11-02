package com.funi.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhihuan.niu
 */
@Controller
public class LoginController extends BaseController{
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("/login");
    }
}
