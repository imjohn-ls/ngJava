package com.imjohn.service;

import com.imjohn.entity.User;
import com.imjohn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhangwei
 * @date 2021-05-06 下午 5:20
 */
@Service
public class UserService {
    @Autowired
    UserMapper usermapper;
    /*<!--根据用户名查询用户信息-->*/
    public User Sel(String userName){
        return usermapper.Sel(userName);
    }
    /*判断是否存在用户*/
    public List<Map> hasUserName(String userName){
        return usermapper.hasUserName(userName);
    }
    /*插入用户注册信息*/
    public int AddUser(User user) {
        return usermapper.AddUser(user);
    }
    /*用户登录*/
    public List<Map> UserLogin(String userName, String passWord) {
        return  usermapper.UserLoginMap(userName, passWord);
    }
}
