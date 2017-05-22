package com.test.service;

import java.util.Date;

import javax.annotation.Resource;

import com.factoring.core.feature.test.TestSupport;
import com.factoring.core.util.ApplicationUtils;
import com.factoring.web.model.User;
import com.factoring.web.service.UserService;

public class UserServiceTest extends TestSupport {

    @Resource
    private UserService userService;

//    @Test
    public void test_insert() {
        User model = new User();
        model.setUsername("");
        model.setPassword(ApplicationUtils.sha256Hex("123456"));
        model.setCreateTime("");
        userService.insert(model);
    }

//    @Test
    public void test_10insert() {
        for (int i = 0; i < 10; i++) {
            User model = new User();
            model.setUsername("" + i);
            model.setPassword(ApplicationUtils.sha256Hex("123456"));
            model.setCreateTime("");
            userService.insert(model);
        }
    }

}
