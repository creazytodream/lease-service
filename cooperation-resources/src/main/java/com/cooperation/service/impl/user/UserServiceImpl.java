package com.cooperation.service.impl.user;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cooperation.mapper.user.UserMapper;
import com.cooperation.model.UserInfo;
import com.cooperation.service.user.UserService;
import com.cooperation.utils.Base64Utils;
import com.cooperation.utils.IDUtils;
import com.cooperation.utils.response.DefaultResultCode;
import com.cooperation.utils.response.HttpResult;
import org.springframework.stereotype.Service;

/**
 * 用户业务类
 *
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 13:53 2018/6/7
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserInfo> implements UserService {

    /**
     * @see UserService#setUserStatus(java.lang.String, java.lang.String)
     */
    @Override
    public int setUserStatus(String userID, String status) {
        return this.baseMapper.setUserStatus(userID,status);
    }

    /**
     * @see UserService#setUserPwd(java.lang.String, java.lang.String)
     */
    @Override
    public int setUserPwd(String userID, String pwd) {
        return this.baseMapper.setUserPwd(userID,pwd);
    }

    /**
     * @see UserService#selectUserInfoByID(com.cooperation.model.UserInfo)
     */
    @Override
    public UserInfo selectUserInfoByID(UserInfo userInfo) {
        return this.baseMapper.selectById(userInfo);
    }

    /**
     * @see UserService#userLogin(com.cooperation.model.UserInfo)
     */
    @Override
    public HttpResult userLogin(UserInfo userInfo) {
        UserInfo info = this.baseMapper.selectById(userInfo);

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
        return HttpResult.newCorrectResult(info);
    }

    /**
     * @see UserService#userOut(com.cooperation.model.UserInfo)
     */
    @Override
    public HttpResult userOut(UserInfo userInfo) {
        return null;
    }

    /**
     * @see UserService#registUserInfo(com.cooperation.model.UserInfo)
     */
    @Override
    public HttpResult registUserInfo(UserInfo userInfo) {
        // 设置用户主键ID
        userInfo.setUserID(IDUtils.getID());
        // 加密用户密码
        userInfo.setPassword(Base64Utils.encryption(userInfo.getPassword()));
        // 这是用户默认为可用状态
        userInfo.setEnable(true);
        Integer insert = this.baseMapper.insert(userInfo);
        return HttpResult.newCorrectResult();
    }

}
