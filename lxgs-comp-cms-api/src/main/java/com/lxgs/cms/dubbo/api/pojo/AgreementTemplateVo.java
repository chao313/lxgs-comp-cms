package com.lxgs.cms.dubbo.api.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liujie
 * @Date 2017/5/4
 * 盛大小贷
 */
@Data
public class AgreementTemplateVo implements Serializable {

    private String id ;
    /**页面ID*/
    private String pageId ;
    /**用途*/
    private String useType ;
    /**协议标题*/
    private String  agreementTitle ;
    /**协议URL*/
    private String agreementUrl ;
    private Date createTime ;
    private Date updateTime ;
    /**删除标志*/
    private int deleteFlag;
}
