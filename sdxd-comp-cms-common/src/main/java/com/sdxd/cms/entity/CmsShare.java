package com.sdxd.cms.entity;

import com.sdxd.framework.entity.BaseEntity;

import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name="t_cms_share")
public class CmsShare extends BaseEntity{
	private String title;
	private String content;
	private String imageCode;	//图片code
	private String imageUrl;	//图片地址
	private String link;		//连接地址
	private String description;
	private Integer deleteFlag;

}
