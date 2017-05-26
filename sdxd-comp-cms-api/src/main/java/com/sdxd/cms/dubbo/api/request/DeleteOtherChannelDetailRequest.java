package com.sdxd.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DeleteOtherChannelDetailRequest extends BaseRequest {

    private String id ;
}
