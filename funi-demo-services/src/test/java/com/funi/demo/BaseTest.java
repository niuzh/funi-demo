package com.funi.demo;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhihuan.niu on 2017/4/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)//指定测试运行器
@ContextConfiguration({//指定Spring配置文件
        "classpath*:config.spring/spring-*.xml",//数据源配置
})
public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
}
