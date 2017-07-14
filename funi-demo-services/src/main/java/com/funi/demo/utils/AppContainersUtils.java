package com.funi.demo.utils;

import com.funi.demo.supports.DemoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * 读取服务器环境变量
 * @author zhihuan.niu on 7/14/17.
 */
public class AppContainersUtils {
    private static final Logger _log = LoggerFactory.getLogger(AppContainersUtils.class);
    private static AppContainersUtils _instance = new AppContainersUtils();

    public static String readEnvironment(String key) {
        String configValue;
        try {
            InitialContext e = new InitialContext();
            Context envContext = (Context) e.lookup("java:comp/env");
            configValue = (String) envContext.lookup(key);
            if (StringUtils.hasText(configValue)) {
                _log.info("Found JNDI environment[" + key + "]: " + configValue);
                return configValue;
            }
        } catch (Exception var4) {
            configValue = System.getProperty(key);
            if (StringUtils.hasText(configValue)) {
                _log.info("Found JSP environment[" + key + "]: " + configValue);
                return configValue;
            }
        }

        throw new DemoException(key + " environment not found");
    }

    private AppContainersUtils() {
    }
}
