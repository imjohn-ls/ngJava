package com.imjohn.entity;

import lombok.Data;

/**
 * @author zhangwei
 * @date 2021-05-06 下午 5:16
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
