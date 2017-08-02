package com.sdxd.cms.entity;

import javax.persistence.Table;

import com.sdxd.framework.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name="T_CMS_BANNER")
public class CmsBanner extends BaseEntity{
	private String name;
	private String type;
	private String imageCode;//图片code
	private String imageUrl;//图片地址
	private String imageLink;//图片连接地址
	private Integer  imageOrder;//图片的顺序，
	private Integer deleteFlag;
	private String pageId;//页面id
	private String position;//页面位置
}
