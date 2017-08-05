package com.sdxd.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by matteo on 2017/8/5.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmstomNoticeRequest extends BaseRequest {
    private Boolean status;//true 线上  false 全部
}
