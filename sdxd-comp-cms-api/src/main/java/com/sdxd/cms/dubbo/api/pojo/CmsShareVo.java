package com.sdxd.cms.dubbo.api.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CmsShareVo implements Serializable{
	private String id;
	private String title;
	private String content;
	private String imageCode;	//图片code
	private String imageUrl;	//图片地址
	private String link;		//连接地址
	private String description;
}
