package com.imjohn.entity;

import lombok.Data;
import org.apache.tomcat.util.descriptor.web.MessageDestinationRef;

/**
 * @author zhangwei
 * @date 2021-07-21 下午 3:32
 */
@Data
public class Aticle {
    private String aticleTitle;
    private String writeDate;
    private String aticleAuthor;
    private String aticleContent;
}
