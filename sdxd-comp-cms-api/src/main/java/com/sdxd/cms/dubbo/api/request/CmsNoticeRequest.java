package com.sdxd.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.BaseRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class CmsNoticeRequest extends BaseRequest {

    private String id; //更新  删除必传
    private String title;
    private String link;
    private Date offlineTime;
    private Boolean status;//true 线上  false 下线
}
