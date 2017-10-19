package com.sdxd.cms.dubbo.api.request;

import com.sdxd.cms.dubbo.api.pojo.CmsSuspensionSettingVo;
import com.sdxd.framework.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class CmsSuspensionSettingRequest extends BaseRequest{
	private String id;
	private CmsSuspensionSettingVo cmsSuspensionSettingVo;
	
}
