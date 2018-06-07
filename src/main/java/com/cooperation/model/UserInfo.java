package com.cooperation.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 11:20 2018/6/7
 */
@Data
@TableName("t_user")
public class UserInfo extends Model<UserInfo> {

    /**
     * 用户主键ID
     */
    @TableId(value = "user_id",type = IdType.INPUT)
    private String userID;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户手机号，也是登陆账号
     */
    private Integer phone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String head;

    /**
     * 用户性别
     */
    private String gender;

    /**
     * 用户财产表外键
     */
    private String propertyId;

    /**
     * 用户创建时间
     */
    private Date createDate;

    /**
     * 用户状态
     */
    private Boolean enable;

    @Override
    protected Serializable pkVal() {
        return this.userID;
    }

}
