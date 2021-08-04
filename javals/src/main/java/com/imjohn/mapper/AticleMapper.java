package com.imjohn.mapper;

import com.imjohn.entity.Aticle;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zhangwei
 * @date 2021-07-21 下午 4:44
 */
@Repository
public interface AticleMapper {
    int AddAticle(Aticle aticle);
    List<Map> GetAticle(String userName);
}
