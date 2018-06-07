package com.cooperation.service.impl;

import com.cooperation.model.UserInfo;
import com.cooperation.service.UserService;
import com.cooperation.utils.response.HttpResult;
import org.junit.Before;
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
    private UserServiceImpl userService;


    @Test
    public void registUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setCreateDate(new Date());
        userInfo.setEnable(true);
        userInfo.setGender("女");
        userInfo.setHead("头像");
        userInfo.setNickname("El");
        userInfo.setPassword("1234567");
        userInfo.setPhone(1111111);
        HttpResult httpResult = userService.registUserInfo(userInfo);
        System.out.println(httpResult);

    }

    @Test
    public void userLogin() {

        UserInfo userInfo = new UserInfo();
        userInfo.setCreateDate(new Date());
        userInfo.setUserID("950001");
        userInfo.setEnable(true);
        userInfo.setGender("女");
        userInfo.setHead("头像");
        userInfo.setNickname("El");
        userInfo.setPassword("1234567");
        userInfo.setPhone(1111111);
        HttpResult httpResult = userService.userLogin(userInfo);
        System.out.println(httpResult);

    }
}