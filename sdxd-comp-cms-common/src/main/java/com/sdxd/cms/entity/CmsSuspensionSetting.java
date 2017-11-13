package com.sdxd.cms.entity;

import com.sdxd.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name="t_cms_suspension_setting")
public class CmsSuspensionSetting extends BaseEntity{

    private String activityName;
    private String imageUrl;
    private String redirectUrl;
    private Integer deleteFlag;

}
