package com.funi.demo.provider.service.impl;

import com.alibaba.dubbo.common.json.JSON;
import com.funi.demo.mbg.dto.User;
import com.funi.demo.service.IAppInvocationRegistryService;
import com.funi.demo.service.IUserService;
import com.funi.demo.supports.AppInvocationResult;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zhihuan.niu on 7/12/17.
 */
@Service(value = "testRegistryService")
public class TestRegistryServiceImpl implements IAppInvocationRegistryService,ApplicationContextAware{
    private ApplicationContext applicationContext;
    @Resource
    private IUserService userService;
    @Override
    public AppInvocationResult invoke(String invocation, String params){
        AppInvocationResult result= new AppInvocationResult();
        //Object object=applicationContext.getBean(invocation.split(".")[0]);
        /*Method method=object.getClass().getMethod(invocation);
        method.invoke(object,params);*/
        User user=userService.findUserByUserName(params);
        result.setMessage(invocation+"-"+params);
        try {
            result.setData(JSON.json(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
