package com.imjohn.controller;

import com.imjohn.entity.Aticle;
import com.imjohn.service.AticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangwei
 * @date 2021-07-21 下午 4:35
 */
@RestController
@RequestMapping("/api")
public class AticleController {
    @Autowired
    private AticleService aticleService;

    /*写入文章*/
    @RequestMapping("/writeAticle")
    public Map WriteAticle(@RequestBody Aticle aticle) {
        int i = aticleService.AddAticle(aticle);
        Map res = new HashMap();
        if (i == 1) {
            res.put("respMsg", "success");
            res.put("respCode", "00000000");
        } else {
            res.put("data", "12345678");
            res.put("respCode", "failed");
        }

        return res;
    }
    /*根据用户名查文章*/
    @RequestMapping("/getArticle")
    public List<Map> getArticle(HttpServletRequest request, @RequestBody Map map) {
        String userName = (String) request.getSession().getAttribute("userName");
        List<Map> res = aticleService.GetAticle(userName);
        return  res;
    }
}
