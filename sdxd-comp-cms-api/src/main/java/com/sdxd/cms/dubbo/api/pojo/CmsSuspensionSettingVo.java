package com.sdxd.cms.dubbo.api.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CmsSuspensionSettingVo implements Serializable{
	private String id;
	private String activityName;
	private String imageUrl;
	private String redirectUrl;
	private Date createTime ;
	private Date updateTime ;


}
