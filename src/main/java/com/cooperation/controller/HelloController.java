package com.cooperation.controller;

import com.cooperation.model.UserVO;
import org.apache.catalina.User;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author zhoukai
 * @date 2018/6/6
 */
@RestController
@RequestMapping("/user")
public class HelloController {

    @RequestMapping(value = "/{address}/{name}", method = RequestMethod.GET)
    public List<UserVO> name(@PathVariable("address") String addr, @PathVariable("name") String name) {
        UserVO userVO = new UserVO("1", "zhangsan", "shanghai");
        UserVO userVO1 = new UserVO("2", "zhangsan", "shanghai");
        UserVO userVO2 = new UserVO("3", "zhangsan", "beijing");
        UserVO userVO3 = new UserVO("4", "lisi", "beijing");
        List<UserVO> list = new ArrayList<>();
        list.add(userVO);
        list.add(userVO1);
        list.add(userVO2);
        list.add(userVO3);
        List<UserVO> resultList = list.stream().filter(user -> {
            return addr.equals(user.getAddress()) && name.equals(user.getName());
        }).collect(toList());
        return resultList;
    }
}
