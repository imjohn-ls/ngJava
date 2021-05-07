package com.imjohn.controller;

import com.imjohn.entity.User;
import com.imjohn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangwei
 * @date 2021-05-06 下午 5:20
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    /*根据id查询用户*/
    @RequestMapping("/getUser")
    public Map GetUser(@RequestBody User user) {
        Map res = new HashMap();
        User users = userService.Sel(user.getId());
        res.put("data" ,users);
        res.put("respCode" ,"00000000");
        return res;
    }
    /*添加用户 注册*/
    @RequestMapping("/addUser")
    public Map AddUser(@RequestBody User user) {
        int i =  userService.AddUser(user);
        Map map = new HashMap<>();
        if (i == 1) {
            map.put("respCode", "00000000");
            map.put("respMsg", "成功");
        } else {
            map.put("respCode", "12345678");
            map.put("respMsg", "失败");
        }
        return map;
    }
}
