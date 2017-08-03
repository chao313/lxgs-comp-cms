package com.sdxd.cms.dubbo.api.response;

import java.util.Date;
import java.util.List;

import com.sdxd.cms.dubbo.api.pojo.CmsNoticeVo;
import com.sdxd.framework.dubbo.BaseResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class QueryCmsNoticeResponse extends BaseResponse {
    private List<CmsNoticeVo> list;
}
