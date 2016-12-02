package com.sdxd.cms.dubbo.api.response;

import com.sdxd.framework.dubbo.BaseResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CmsNoticeResponse extends BaseResponse {

	private Boolean success;
}
