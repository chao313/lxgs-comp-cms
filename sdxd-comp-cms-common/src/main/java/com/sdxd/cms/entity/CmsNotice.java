package com.sdxd.cms.entity;

import javax.persistence.Table;

import com.sdxd.framework.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name = "T_CMS_NOTICE")
public class CmsNotice extends BaseEntity {
	
	private String title;
	private String link;
	private Integer delete_flag;
}
