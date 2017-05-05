package com.sdxd.cms.entity;

import com.sdxd.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Table;

/**
 * @author liujie
 * @Date 2017/5/4
 * 盛大小贷
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name="t_agreement_template_manage")
public class AgreementTemplateManage extends BaseEntity {
    /**页面ID*/
    private String pageId ;
    /**用途*/
    private String useType ;
    /**协议标题*/
    private String  agreementTitle ;
    /**协议URL*/
    private String agreementUrl ;
    /**删除标志*/
    private int deleteFlag;
}
