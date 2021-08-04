package com.imjohn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangwei
 * @date 2021-07-05 下午 5:41
 */
@RestController
@RequestMapping("/api")
public class RestApi {
    @RequestMapping("/proList")
    public Map resMap(){
        Map res = new HashMap();
        res.put("name", "sdf");
        return  res;
    }
}
