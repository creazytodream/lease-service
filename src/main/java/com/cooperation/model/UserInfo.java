package com.cooperation.model;

import lombok.Data;
import java.util.Date;

/**
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 11:20 2018/6/7
 */
@Data
public class UserInfo {

    private String userID;

    private String nickname;

    private Integer phone;

    private String password;

    private String head;

    private String gender;

    private String propertyID;

    private Date createDate;

    private Boolean enable;

}
