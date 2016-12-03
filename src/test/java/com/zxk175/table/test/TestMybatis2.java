package com.zxk175.table.test;

import com.zxk175.table.pojo.User;
import com.zxk175.table.pojo.UserExample;
import com.zxk175.table.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zxk175 on 16/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class TestMybatis2 {
    private static final Logger log = LogManager.getLogger(TestMybatis2.class);

    @Autowired
    private UserService userService;

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