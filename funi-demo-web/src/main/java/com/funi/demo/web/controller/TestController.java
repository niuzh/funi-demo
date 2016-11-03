package com.funi.demo.web.controller;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author zhihuan.niu on 2016/11/3.
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public void test(HttpServletRequest request,HttpServletResponse response) throws Exception{
        Resource resource=new ServletContextResource(request.getSession().getServletContext(),"niu.txt");
        if(!resource.exists()){
            resource.createRelative("niu.txt");
        }
        File file=resource.getFile();
        OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
        writer.append("niu");
        writer.flush();
        writer.close();
    }
}
