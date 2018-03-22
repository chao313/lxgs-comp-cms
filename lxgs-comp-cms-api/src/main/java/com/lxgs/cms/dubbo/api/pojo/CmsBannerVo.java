package com.lxgs.cms.dubbo.api.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CmsBannerVo implements Serializable {

    private String id;
    private String name;
    private String type;//类型：WEB，APP，H5,
    private String imageCode;//图片code
    private String imageUrl;//图片地址
    private String imageLink;//图片连接地址
    private Integer imageOrder;//图片的顺序
    private String pageId;//页面id
    private String position;//页面位置
}
