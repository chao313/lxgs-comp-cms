package com.lxgs.cms.dubbo.api.request;

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
public class DeleteAgreementTemplateRequest extends BaseRequest {

    private Integer id ; //页面ID
}
