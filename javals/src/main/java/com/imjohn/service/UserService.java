package com.imjohn.service;

import com.imjohn.entity.User;
import com.imjohn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangwei
 * @date 2021-05-06 下午 5:20
 */
@Service
public class UserService {
    @Autowired
    UserMapper usermapper;
    public User Sel(int id){
        return usermapper.Sel(id);
    }
    public int AddUser(User user) {
        return usermapper.AddUser(user);
    }
}
