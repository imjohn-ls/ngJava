package com.imjohn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangwei
 * @date 2021-05-06 下午 3:24
 */
@Controller
public class Test {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "john");
        model.addAttribute("age", 20);
        model.addAttribute("info", "imjohn");
        return "index";
    }
}
