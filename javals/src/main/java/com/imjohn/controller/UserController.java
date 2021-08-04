package com.imjohn.controller;

import com.imjohn.entity.User;
import com.imjohn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

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
        User users = userService.Sel(user.getUserName());
        if (users == null) {
            res.put("respCode", "12345678");
            res.put("respMsg", "失败");
        } else {
            res.put("data" ,users);
            res.put("respCode" ,"00000000");
        }

        return res;
    }
    /*添加用户 注册*/
    @RequestMapping("/addUser")
    public Map AddUser(@RequestBody User user) {
        List<Map> iMap = (List<Map>) userService.hasUserName(user.getUserName());
        Map map = new HashMap<>();
        if (iMap.size() > 0) {
            map.put("respCode", "12345678");
            map.put("respMsg", "已存在用户！");
        } else if (iMap.size() == 0){
            int j =  userService.AddUser(user);
            if (j > 0) {
                map.put("respCode", "00000000");
                map.put("respMsg", "注册成功");
            } else {
                map.put("respCode", "12345678");
                map.put("respMsg", "操作失败！");
            }
        }else {
            map.put("respCode", "12345678");
            map.put("respMsg", "系统错误！");
        }
        return map;
    }
    /*登录 */
    @RequestMapping("/userLogin")
    public Map UserLogin(HttpServletRequest request, @RequestBody User user) {
        Map res = new HashMap();
        List<Map> users = userService.UserLogin(user.getUserName(), user.getPassWord());
        if (users.size() == 0) {
            res.put("respCode", "12345678");
            res.put("respMsg", "账号或密码错误!");
        } else {
            /*获取session*/
            HttpSession session = request.getSession();
            /*session超时时间*/
            request.getSession().setMaxInactiveInterval(5*120);
            session.setAttribute("userName",users.get(0).get("userName"));
            res.put("data" ,users);
            res.put("respCode" ,"00000000");
        }
        return res;
    }
}
