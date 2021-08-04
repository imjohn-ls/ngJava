package com.imjohn.service;

import com.imjohn.entity.Aticle;
import com.imjohn.entity.User;
import com.imjohn.mapper.AticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhangwei
 * @date 2021-07-21 下午 4:41
 */
@Service
public class AticleService {
    @Autowired
    AticleMapper aticleMapper;
    public int AddAticle(Aticle aticle) {
        return aticleMapper.AddAticle(aticle);
    }
    public List<Map> GetAticle(String userName) {
        return  aticleMapper.GetAticle(userName);
    }

}
