package com.lxgs.cms.dubbo.api;

import com.lxgs.cms.dubbo.api.request.CmsShareRequest;
import com.lxgs.cms.dubbo.api.request.CmsShareUpdateRequest;
import com.lxgs.cms.dubbo.api.request.CmsSuspensionSettingRequest;
import com.lxgs.cms.dubbo.api.response.CmsShareResponse;
import com.lxgs.cms.dubbo.api.response.CmsSuspensionSettingListResponse;
import com.lxgs.cms.dubbo.api.response.CmsSuspensionSettingResponse;
import com.sdxd.framework.dubbo.DubboResponse;

public interface CmsSuspensionSettingDubboService {

	DubboResponse<CmsSuspensionSettingResponse> saveCmsSuspensionSetting(CmsSuspensionSettingRequest request);

	DubboResponse<CmsSuspensionSettingResponse> updateCmsSuspensionSetting(CmsSuspensionSettingRequest request);

	DubboResponse<CmsSuspensionSettingResponse> deleteCmsSuspensionSetting(CmsSuspensionSettingRequest request);

}
