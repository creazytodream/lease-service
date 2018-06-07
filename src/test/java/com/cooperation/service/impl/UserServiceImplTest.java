package com.cooperation.service.impl;

import com.cooperation.model.UserInfo;
import com.cooperation.service.UserService;
import com.cooperation.utils.response.HttpResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 16:04 2018/6/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void registUserInfo() {

        UserInfo userInfo = new UserInfo();
        userInfo.setCreateDate(new Date());
        userInfo.setEnable(true);
        userInfo.setGender("男");
        userInfo.setHead("头像");
        userInfo.setNickname("Alex");
        userInfo.setPassword("123456");
        userInfo.setPhone(1111111);

        HttpResult httpResult = userService.registUserInfo(userInfo);
        System.out.println(httpResult);

    }
}