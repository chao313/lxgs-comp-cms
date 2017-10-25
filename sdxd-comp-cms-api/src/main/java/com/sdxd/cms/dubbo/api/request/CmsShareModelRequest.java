package com.sdxd.cms.dubbo.api.request;


import com.sdxd.framework.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class CmsShareModelRequest extends BaseRequest{

    @NotNull
    private String id;

    @NotNull
    private String userId;

}
