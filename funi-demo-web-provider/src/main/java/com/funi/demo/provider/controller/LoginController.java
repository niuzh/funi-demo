package com.funi.demo.provider.controller;

import com.funi.demo.service.IUserService;
import com.funi.demo.provider.supports.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录业务控制器
 * @author zhihuan.niu
 */
@Controller
public class LoginController extends BaseController {
    
    protected static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    /*
    * ModelAndView 包括视图信息和渲染视图的模型数据信息
    * 数据模型对象放置到request的属性中
    * */

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request){
        logger.debug("debug start login");
        if(request.getSession().getAttribute("user")!=null){
            return new ModelAndView("main");
        }else {
            return new ModelAndView("login");
        }
    }
}
