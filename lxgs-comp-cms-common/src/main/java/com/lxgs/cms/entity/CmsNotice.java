package com.lxgs.cms.entity;

import javax.persistence.Table;

import com.sdxd.framework.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name = "T_CMS_NOTICE")
public class CmsNotice extends BaseEntity {
	
	private String title;
	private String link;
	private Date offlineTime;
	private String merchantNo;
	private Integer deleteFlag;
}
