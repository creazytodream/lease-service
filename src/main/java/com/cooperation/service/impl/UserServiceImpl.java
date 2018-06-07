package com.cooperation.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cooperation.mapper.UserMapper;
import com.cooperation.model.UserInfo;
import com.cooperation.service.UserService;
import com.cooperation.utils.IDUtils;
import com.cooperation.utils.response.DefaultResultCode;
import com.cooperation.utils.response.HttpResult;
import org.springframework.stereotype.Service;

/**
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 13:53 2018/6/7
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserInfo> implements UserService {

    @Override
    public int setUserStatus(String userID, String status) {
        return this.baseMapper.setUserStatus(userID,status);
    }

    @Override
    public int setUserPwd(String userID, String pwd) {
        return this.setUserPwd(userID,pwd);
    }

    @Override
    public UserInfo selectUserInfoByID(String userID) {
        return this.selectUserInfoByID(userID);
    }

    @Override
    public HttpResult userLogin(UserInfo userInfo) {
        UserInfo info = this.baseMapper.selectOne(userInfo);

        // 用户不存在
        if (null == info){
            return HttpResult.newErrorResult(DefaultResultCode.USER_NULL);
        }

        // 用户状态不可用
        if ("0".equals(info.getEnable())){
            return HttpResult.newErrorResult(DefaultResultCode.USER_ACTIVATION);
        }

        // 用户密码错误
        if (!info.getPassword().equals(userInfo.getPassword())){
            return HttpResult.newErrorResult(DefaultResultCode.USER_ERROE);
        }
        return HttpResult.newCorrectResult();
    }

    @Override
    public HttpResult userOut(UserInfo userInfo) {
        return null;
    }

    @Override
    public HttpResult registUserInfo(UserInfo userInfo) {
        userInfo.setUserID(IDUtils.getID());
        Integer insert = this.baseMapper.insert(userInfo);
        return HttpResult.newCorrectResult();
    }

}
