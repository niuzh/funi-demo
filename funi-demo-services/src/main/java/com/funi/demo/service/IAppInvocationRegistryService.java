package com.funi.demo.service;

import com.funi.demo.supports.AppInvocationResult;

/**
 * zookeeper 服务接口
 * 服务接口
 */
public interface IAppInvocationRegistryService {
    /**
     * 远端服务接口
     * @param invocation
     * @param params
     * @return
     */
    AppInvocationResult invoke(String invocation, String params);
}
