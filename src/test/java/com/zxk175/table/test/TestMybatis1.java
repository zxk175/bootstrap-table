package com.zxk175.table.test;

import com.zxk175.table.pojo.User;
import com.zxk175.table.pojo.UserExample;
import com.zxk175.table.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by zxk175 on 16/11/13.
 */
public class TestMybatis1 {
    private static final Logger log = LogManager.getLogger(TestMybatis1.class);
    private ApplicationContext context;
    private UserService userService;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("classpath*:spring/spring-*.xml");
        userService = (UserService) context.getBean("userService");
    }

    @Test
    public void test1() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo((long) 1);
        criteria.andIsDeleteEqualTo((short) 0);
        List<User> users = userService.getAllUserByExample(example);
        String str = null;
        for (User user : users) {
            str = user.getUserName();
            log.trace(str);
            log.debug(str);
            log.error(str);
            log.warn(str);
            log.info(str);
        }
    }
}
