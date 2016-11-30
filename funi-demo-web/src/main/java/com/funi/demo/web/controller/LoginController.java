package com.funi.demo.web.controller;

import com.funi.demo.authority.domain.User;
import com.funi.demo.authority.service.IUserService;
import com.funi.demo.web.command.LoginCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 登录业务控制器
 * @author zhihuan.niu
 */
@Controller
public class LoginController extends BaseController{
    @Autowired
    private IUserService userService;
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
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(){
        logger.debug("debug start login");
        logger.info("info start login");
        return new ModelAndView("login");
    }

    /**
     * 验证用户
     * @param request
     * @param command
     * @return
     */
    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand command){
        ModelAndView modelAndView=new ModelAndView();
        try {
            boolean isValidUser=userService.hasMatchUser(command.getUserName(), command.getPassword());
            if(isValidUser){
                User user=userService.findUserByUserName(command.getUserName());
                user.setLastIp(request.getRemoteAddr());
                user.setLastVisit(new Date());
                userService.loginSuccess(user);
                request.getSession().setAttribute("user", user);
                modelAndView.setViewName("main");
            }
        }catch (Exception e){
            modelAndView= new ModelAndView("login","error",e.getMessage());
        }
        return modelAndView;
    }
}
