package com.imjohn.mapper;

import com.imjohn.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zhangwei
 * @date 2021-05-06 下午 5:25
 */
@Repository
public interface UserMapper {
    /*<!--根据用户名查询用户信息-->*/
    User Sel(String userName);
    /*插入用户注册信息*/
    int AddUser(User user);
    /*判断是否存在用户*/
    List<Map> hasUserName(String userName);
//    User UserLogin(String userName, String passWord);

    List<Map> UserLoginMap(String userName, String passWord);
}
