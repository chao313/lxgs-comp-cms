package com.lxgs.cms.dubbo.api.response;

import com.lxgs.cms.dubbo.api.pojo.CmsSuspensionSettingVo;
import com.sdxd.framework.dubbo.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CmsSuspensionSettingListResponse extends BaseResponse {
	private List<CmsSuspensionSettingVo> cmsSuspensionSettingVoList;
}
