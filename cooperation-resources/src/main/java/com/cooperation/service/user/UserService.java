package com.cooperation.service.user;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cooperation.model.UserInfo;
import com.cooperation.utils.response.HttpResult;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 13:08 2018/6/7
 */
public interface UserService extends IService<UserInfo> {

    /**
     * 修改用户的状态
     */
    int setUserStatus(String userID,String status);

    /**
     * 修改用户的密码
     */
    int setUserPwd(String userID,String pwd);

    /**
     * 通过用户ID获取到用户
     */
    UserInfo selectUserInfoByID(UserInfo userInfo);

    /**
     * 用户登陆
     */
    HttpResult userLogin(UserInfo userInfo);

    /**
     * 用户登出
     */
    HttpResult userOut(UserInfo userInfo);

    /**
     * 注册一个用户
     */
    HttpResult registUserInfo(UserInfo userInfo);

}
