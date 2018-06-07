package com.cooperation.controller.user;

import com.cooperation.model.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 11:26 2018/6/7
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController extends com.cooperation.controller.user.BaseController {

    @PostMapping(value = "/login")
    public void userLogin(@RequestBody UserInfo userInfo){

    }

}
