package com.funi.demo.service.impl;

import com.funi.demo.service.ITestRegistryService;
import org.springframework.stereotype.Service;

/**
 * @author zhihuan.niu on 7/12/17.
 */
@Service(value = "testRegistryService")
public class TestRegistryServiceImpl implements ITestRegistryService {
    @Override
    public String hello(String name) {
        return "hello"+name;
    }
}
