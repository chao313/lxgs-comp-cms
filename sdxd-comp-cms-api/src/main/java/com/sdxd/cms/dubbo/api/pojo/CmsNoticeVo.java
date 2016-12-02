package com.sdxd.cms.dubbo.api.pojo;

import java.io.Serializable;

import lombok.Data;
@Data
public class CmsNoticeVo implements Serializable{

	private String id;
	private String title;
	private String link;
}
