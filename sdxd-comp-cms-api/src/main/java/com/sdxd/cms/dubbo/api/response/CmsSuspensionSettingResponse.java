package com.sdxd.cms.dubbo.api.response;

import com.sdxd.cms.dubbo.api.pojo.CmsShareVo;
import com.sdxd.cms.dubbo.api.pojo.CmsSuspensionSettingVo;
import com.sdxd.framework.dubbo.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CmsSuspensionSettingResponse extends BaseResponse {
	private CmsSuspensionSettingVo cmsSuspensionSettingVo;
}
