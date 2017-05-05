package com.sdxd.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liujie
 * @Date 2017/5/4
 * 盛大小贷
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AgreementTemplateRequest extends BaseRequest {

    /**页面ID*/
    private String pageId ;
    /**用途*/
    private String useType ;
    /**协议标题*/
    private String  agreementTitle ;
    /**协议URL*/
    private String agreementUrl ;
}
