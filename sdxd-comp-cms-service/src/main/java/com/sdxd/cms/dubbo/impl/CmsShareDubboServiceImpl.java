package com.sdxd.cms.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sdxd.activities.api.ActivityDubboService;
import com.sdxd.activities.api.dto.activity.ActivityInfo;
import com.sdxd.activities.api.dto.activity.QueryByKeyReq;
import com.sdxd.cms.dubbo.api.CmsShareDubboService;
import com.sdxd.cms.dubbo.api.pojo.CmsShareVo;
import com.sdxd.cms.dubbo.api.request.CmsShareModelRequest;
import com.sdxd.cms.dubbo.api.request.CmsShareRequest;
import com.sdxd.cms.dubbo.api.request.CmsShareUpdateRequest;
import com.sdxd.cms.dubbo.api.response.CmsShareResponse;
import com.sdxd.cms.entity.CmsShare;
import com.sdxd.cms.service.CmsShareService;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.common.utils.KeyUtils;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dubbo.DubboResponse;

import com.sdxd.user.api.UserService;
import com.sdxd.user.api.request.InvitationRequest;
import com.sdxd.user.api.request.UserBaseRequest;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.*;

@Service(interfaceName = "com.sdxd.cms.dubbo.api.CmsShareDubboService", validation = "true", version = "1.0.0", timeout = 30000)
public class CmsShareDubboServiceImpl implements CmsShareDubboService {

	private static final Logger log = LoggerFactory.getLogger(CmsShareDubboServiceImpl.class);

	@Resource
	private CmsShareService cmsShareService;

	@Reference(version = "1.0.0")
    private UserService userService;

	@Reference(version = "1.0.0")
	private ActivityDubboService activityService;

	@Override
	public DubboResponse<CmsShareResponse> findById(CmsShareRequest request) {
		DubboResponse<CmsShareResponse> response = new DubboResponse<CmsShareResponse>();
		response.setError(Constants.System.SERVER_SUCCESS);
		response.setStatus(Constants.System.OK);

		String id = request.getId();
		CmsShare cmsShare = cmsShareService.getById(id);
		if(cmsShare==null) {
			response.setError(Constants.System.PARAMS_INVALID);
			response.setMsg(Constants.System.PARAMS_INVALID_MSG);
			return response;
		}

		CmsShareVo cmsShareVo = new CmsShareVo();
		cmsShareVo.setId(cmsShare.getId());
		cmsShareVo.setTitle(cmsShare.getTitle());
		cmsShareVo.setContent(cmsShare.getContent());
		cmsShareVo.setDescription(cmsShare.getDescription());
		cmsShareVo.setImageCode(cmsShare.getImageCode());
		cmsShareVo.setImageUrl(cmsShare.getImageUrl());
		cmsShareVo.setLink(cmsShare.getLink());

		CmsShareResponse data = new CmsShareResponse();
		data.setCmsShareVo(cmsShareVo);
		response.setData(data);

		return response;
	}

	@Override
	public DubboResponse<CmsShareResponse> getCmsShare(CmsShareModelRequest request) {
		DubboResponse<CmsShareResponse> response = new DubboResponse<CmsShareResponse>();
		response.setError(Constants.System.SERVER_SUCCESS);
		response.setStatus(Constants.System.OK);

		String activityKey = request.getActivityKey();
        QueryByKeyReq req = new QueryByKeyReq();
        req.setRequestId(BillNoUtils.GenerateBillNo());
        req.setKey(activityKey);
		DubboResponse<String> dubboResponse = activityService.getCmsShareByActivityKey(req);
		CmsShare cmsShare = cmsShareService.getById(dubboResponse.getData());
		if(cmsShare==null) {
			response.setError(Constants.System.PARAMS_INVALID);
			response.setMsg(Constants.System.PARAMS_INVALID_MSG);
			return response;
		}

		CmsShareVo cmsShareVo = new CmsShareVo();
		cmsShareVo.setId(cmsShare.getId());
		cmsShareVo.setTitle(cmsShare.getTitle());
		cmsShareVo.setContent(cmsShare.getContent());
		cmsShareVo.setDescription(cmsShare.getDescription());
		cmsShareVo.setImageCode(cmsShare.getImageCode());
		cmsShareVo.setImageUrl(cmsShare.getImageUrl());
		Map<String, String> params = new HashMap<>();

		Long userId = request.getUserId();

        UserBaseRequest userBaseRequest = new UserBaseRequest();
        userBaseRequest.setRequestId(BillNoUtils.GenerateBillNo());
        userBaseRequest.setUserId(userId);
        DubboResponse<String> userServiceResponse = userService.queryIvtCode(userBaseRequest);
        String inviteCode = userServiceResponse.getData();

        InvitationRequest invitationRequest = new InvitationRequest();
        invitationRequest.setRequestId(BillNoUtils.GenerateBillNo());
        invitationRequest.setIvtCode(inviteCode);
        DubboResponse<String> queryInviterResponse = userService.queryInviterPhone(invitationRequest);
        String phone = queryInviterResponse.getData();
        phone = phone.length() > 4 ? phone.substring(phone.length() - 4, phone.length()) : "0000";

		params.put("1", phone);      // phone
		params.put("2", inviteCode); // InviteCode
		cmsShareVo.setLink(KeyUtils.replaceKey(cmsShare.getLink(), params));

		CmsShareResponse data = new CmsShareResponse();
		data.setCmsShareVo(cmsShareVo);
		response.setData(data);

		return response;
	}

}
