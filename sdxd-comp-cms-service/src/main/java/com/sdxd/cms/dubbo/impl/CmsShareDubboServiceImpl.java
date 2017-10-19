package com.sdxd.cms.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sdxd.cms.dubbo.api.CmsShareDubboService;
import com.sdxd.cms.dubbo.api.pojo.CmsShareVo;
import com.sdxd.cms.dubbo.api.request.CmsShareRequest;
import com.sdxd.cms.dubbo.api.request.CmsShareUpdateRequest;
import com.sdxd.cms.dubbo.api.response.CmsShareResponse;
import com.sdxd.cms.entity.CmsShare;
import com.sdxd.cms.service.CmsShareService;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dubbo.DubboResponse;

import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

@Service(interfaceName = "com.sdxd.cms.dubbo.api.CmsShareDubboService", validation = "true", version = "1.0.0", timeout = 30000)
public class CmsShareDubboServiceImpl implements CmsShareDubboService {
	private static final Logger log = LoggerFactory.getLogger(CmsShareDubboServiceImpl.class);
	@Resource
	private CmsShareService cmsShareService;

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


}
