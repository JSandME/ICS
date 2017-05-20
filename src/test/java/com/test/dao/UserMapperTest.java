package com.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.factoring.core.feature.test.TestSupport;
import com.factoring.web.dao.UserMapper;
import com.factoring.web.model.User;
import com.factoring.web.model.UserExample;

public class UserMapperTest extends TestSupport {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test_selectByExampleAndPage() {
        start();
        //Page<User> page = new Page<>(1, 3);
        UserExample example = new UserExample();
        example.createCriteria().andIdGreaterThan(0L);
        //final List<User> users = userMapper.selectByExampleAndPage(page, example);
        /*for (User user : users) {
            System.err.println(user);
        }*/
        end(); 
    }
}
