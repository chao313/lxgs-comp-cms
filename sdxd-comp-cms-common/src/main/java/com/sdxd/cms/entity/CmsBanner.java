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
	private String image_code;//图片code
	private String image_url;//图片地址
	private String image_link;//图片连接地址
	private Integer  image_order;//图片的顺序，
	private Integer delete_flag;
 
}
