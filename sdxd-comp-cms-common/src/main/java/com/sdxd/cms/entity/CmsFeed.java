package com.sdxd.cms.entity;

import com.sdxd.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Table;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.sdxd.cms.entity
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2017/8/17    wenzhou.xu              Created
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name="T_CMS_FEED")
public class CmsFeed extends BaseEntity {
    private String title;
    private String feedUrl;
    private String image1Url;
    private String image2Url;
    private String image3Url;
    private String from;
    private String tag;
    private String isCommont;
    private String isDisplay;
    private Integer deleteFlag;
}
