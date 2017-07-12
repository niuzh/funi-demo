package com.funi.demo.web.controller;

import com.alibaba.dubbo.common.json.JSON;
import com.funi.demo.service.IAppInvocationRegistryService;
import com.funi.demo.supports.AppInvocationResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhihuan.niu on 2016/11/3.
 */
@Controller
public class TestController {
    @Resource
    private IAppInvocationRegistryService appInvocationRegistryService;
    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request,HttpServletResponse response) throws Exception{
        /*Resource resource=new ServletContextResource(request.getSession().getServletContext(),"niu.txt");
        if(!resource.exists()){
            resource.createRelative("niu.txt");
        }
        File file=resource.getFile();
        OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
        writer.append("niu");
        writer.flush();
        writer.close();*/
        AppInvocationResult result= appInvocationRegistryService.invoke("userService.findUserByUserName","admin");
        String returnTxt=result.getData();
        return returnTxt;
    }
}
