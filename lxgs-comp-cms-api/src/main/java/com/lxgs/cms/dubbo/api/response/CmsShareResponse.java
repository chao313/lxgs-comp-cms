package com.lxgs.cms.dubbo.api.response;

import com.lxgs.cms.dubbo.api.pojo.CmsShareVo;
import com.sdxd.framework.dubbo.BaseResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CmsShareResponse extends BaseResponse {
	private CmsShareVo cmsShareVo;
}
