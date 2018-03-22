package com.lxgs.cms.dubbo.api.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author liujie
 * @Date 2017/5/4
 * 盛大小贷
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class DeleteAgreementTemplateResponse {

    private boolean success;
}
