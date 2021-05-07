package com.imjohn.mapper;

import com.imjohn.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author zhangwei
 * @date 2021-05-06 下午 5:25
 */
@Repository
public interface UserMapper {
    User Sel(int id);
    int AddUser(User user);
}
