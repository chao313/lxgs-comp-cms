package com.sdxd.cms.dubbo.api.pojo;

import java.io.Serializable;

import lombok.Data;
@Data
public class CmsBannerVo implements Serializable{

	private String id;
	private String name;
	private String type;//类型：WEB，APP，H5,
	private String image_code;//图片code
	private String image_url;//图片地址
	private String image_link;//图片连接地址
	private Integer image_order;//图片的顺序
}
