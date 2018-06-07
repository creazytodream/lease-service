package com.cooperation.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cooperation.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 13:41 2018/6/7
 */
@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {

    /**
     * 修改用户的状态
     */
    int setUserStatus(@Param("userID")String userID, @Param("status")String status);

    /**
     * 修改用户的密码
     */
    int setUserPwd(@Param("userID")String userID,@Param("pwd")String pwd);

    /**
     * 通过用户ID获取到用户
     */
    UserInfo selectUserInfoByID(@Param("userID")String userID);



}
