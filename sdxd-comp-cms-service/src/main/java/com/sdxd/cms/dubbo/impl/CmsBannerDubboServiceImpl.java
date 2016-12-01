package com.sdxd.cms.dubbo.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.sdxd.cms.dubbo.api.CmsBannerDubboService;
import com.sdxd.cms.dubbo.api.request.CmsBannerRequest;
import com.sdxd.cms.dubbo.api.request.DeleteCmsBannerRequest;
import com.sdxd.cms.dubbo.api.request.QueryCmsBannerRequest;
import com.sdxd.cms.dubbo.api.response.CmsBannerResponse;
import com.sdxd.cms.dubbo.api.response.QueryCmdBannerResponse;
import com.sdxd.cms.entity.CmsBanner;
import com.sdxd.cms.service.CmsBannerService;
import com.sdxd.common.utils.BeanUtils;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dubbo.DubboResponse;
@Service(interfaceName = "com.sdxd.cms.dubbo.api.CmsBannerDubboService", validation = "true", version = "1.0.0", timeout = 30000)
public class CmsBannerDubboServiceImpl implements CmsBannerDubboService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CmsBannerDubboServiceImpl.class);
	@Resource
	private CmsBannerService cmsBannerService;

	@Override
	public DubboResponse<CmsBannerResponse> addCmsBanner(CmsBannerRequest request) {
		LOGGER.debug("addCmsBanner,requestParam:{}",JSONObject.toJSONString(request));
		DubboResponse<CmsBannerResponse> reponse = new DubboResponse<CmsBannerResponse>();
		CmsBannerResponse res = new CmsBannerResponse();
		reponse.setError(Constants.System.SERVER_SUCCESS);
		reponse.setStatus(Constants.System.OK);
		try {
			CmsBanner cmsBanner = new CmsBanner();
			BeanUtils.copyOnPropertyUtils(cmsBanner, request);
			cmsBannerService.insert(cmsBanner);
			res.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("addCmsBanner error",e);
			res.setSuccess(false);
			reponse.setError(Constants.System.SYSTEM_ERROR_CODE);
			reponse.setStatus(Constants.System.FAIL);
		}
		reponse.setData(res);
		return reponse;
	}

	@Override
	public DubboResponse<CmsBannerResponse> updataCmsBanner(CmsBannerRequest request) {
		LOGGER.debug("updataCmsBanner,requestParam:{}",JSONObject.toJSONString(request));
		DubboResponse<CmsBannerResponse> reponse = new DubboResponse<CmsBannerResponse>();
		CmsBannerResponse res = new CmsBannerResponse();
		reponse.setError(Constants.System.SERVER_SUCCESS);
		reponse.setStatus(Constants.System.OK);
		try {
			CmsBanner cmsBanner = new CmsBanner();
			BeanUtils.copyOnPropertyUtils(cmsBanner, request);
			cmsBannerService.update(cmsBanner);
			res.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("updataCmsBanner error",e);
			res.setSuccess(false);
			reponse.setError(Constants.System.SYSTEM_ERROR_CODE);
			reponse.setStatus(Constants.System.FAIL);
		}
		reponse.setData(res);
		return reponse;
	}

	@Override
	public DubboResponse<CmsBannerResponse> deleteCmsBanner(DeleteCmsBannerRequest request) {
		LOGGER.debug("deleteCmsBanner,requestParam:{}",JSONObject.toJSONString(request));
		DubboResponse<CmsBannerResponse> reponse = new DubboResponse<CmsBannerResponse>();
		reponse.setError(Constants.System.SERVER_SUCCESS);
		reponse.setStatus(Constants.System.OK);
		String id = request.getId();
		if(StringUtils.isBlank(id)){
			reponse.setError(Constants.System.PARAMS_INVALID);
			reponse.setStatus(Constants.System.FAIL);
			return reponse;
		}
		CmsBannerResponse res = new CmsBannerResponse();
		try {
			CmsBanner cmsBanner = new CmsBanner();
			cmsBanner.setId(id);
			cmsBanner.setDelete_flag(1);
			cmsBannerService.update(cmsBanner);
			res.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("updataCmsBanner error",e);
			res.setSuccess(false);
			reponse.setError(Constants.System.SYSTEM_ERROR_CODE);
			reponse.setStatus(Constants.System.FAIL);
		}
		reponse.setData(res);
		return reponse;
	}

	@Override
	public DubboResponse<QueryCmdBannerResponse> queryCmsBanner(QueryCmsBannerRequest request) {
		LOGGER.debug("deleteCmsBanner,requestParam:{}",JSONObject.toJSONString(request));
		 DubboResponse<QueryCmdBannerResponse>  reponse = new  DubboResponse<QueryCmdBannerResponse>();
		reponse.setError(Constants.System.SERVER_SUCCESS);
		reponse.setStatus(Constants.System.OK);
		String id = request.getId();
		if(StringUtils.isBlank(id)){
			reponse.setError(Constants.System.PARAMS_INVALID);
			reponse.setStatus(Constants.System.FAIL);
			return reponse;
		}
		QueryCmdBannerResponse res = new QueryCmdBannerResponse();
		try {
			CmsBanner cmsBanner = new CmsBanner();
			BeanUtils.copyOnPropertyUtils(cmsBanner, request);
			cmsBanner.setDelete_flag(0);
			cmsBannerService.findByObj(cmsBanner);
		} catch (Exception e) {
			LOGGER.error("updataCmsBanner error",e);
			reponse.setError(Constants.System.SYSTEM_ERROR_CODE);
			reponse.setStatus(Constants.System.FAIL);
		}
		reponse.setData(res);
		return reponse;
	}

}
