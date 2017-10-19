package com.sdxd.cms.dubbo.api;

import com.sdxd.cms.dubbo.api.request.CmsShareRequest;
import com.sdxd.cms.dubbo.api.request.CmsShareUpdateRequest;
import com.sdxd.cms.dubbo.api.request.CmsSuspensionSettingRequest;
import com.sdxd.cms.dubbo.api.response.CmsShareResponse;
import com.sdxd.cms.dubbo.api.response.CmsSuspensionSettingListResponse;
import com.sdxd.cms.dubbo.api.response.CmsSuspensionSettingResponse;
import com.sdxd.framework.dubbo.DubboResponse;

public interface CmsSuspensionSettingDubboService {

	DubboResponse<CmsSuspensionSettingListResponse> findAll(CmsSuspensionSettingRequest request);

	DubboResponse<CmsSuspensionSettingResponse> findById(CmsSuspensionSettingRequest request);

	DubboResponse<CmsSuspensionSettingResponse> saveCmsSuspensionSetting(CmsSuspensionSettingRequest request);

	DubboResponse<CmsSuspensionSettingResponse> updateCmsSuspensionSetting(CmsSuspensionSettingRequest request);

	DubboResponse<CmsSuspensionSettingResponse> deleteCmsSuspensionSetting(CmsSuspensionSettingRequest request);

}
