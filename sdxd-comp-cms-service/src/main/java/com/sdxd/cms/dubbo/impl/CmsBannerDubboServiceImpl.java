package com.sdxd.cms.dubbo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.sdxd.cms.dubbo.api.CmsBannerDubboService;
import com.sdxd.cms.dubbo.api.pojo.CmsBannerVo;
import com.sdxd.cms.dubbo.api.request.CmsBannerRequest;
import com.sdxd.cms.dubbo.api.request.DeleteCmsBannerRequest;
import com.sdxd.cms.dubbo.api.request.QueryCmsBannerRequest;
import com.sdxd.cms.dubbo.api.response.CmsBannerResponse;
import com.sdxd.cms.dubbo.api.response.QueryCmsBannerResponse;
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
		DubboResponse<CmsBannerResponse> response = new DubboResponse<CmsBannerResponse>();
		response.setError(Constants.System.SERVER_SUCCESS);
		response.setStatus(Constants.System.OK);
		CmsBannerResponse res = new CmsBannerResponse();
		if(StringUtils.isBlank(request.getImageLink())||StringUtils.isBlank(request.getImageCode())
				||StringUtils.isBlank(request.getType())){
			res.setSuccess(false);
			response.setError(Constants.System.PARAMS_INVALID);
			response.setMsg(Constants.System.PARAMS_INVALID_MSG);
			return response;
		}
		try {
			CmsBanner cmsBanner = new CmsBanner();
			BeanUtils.copyOnPropertyUtils(cmsBanner, request);
			cmsBannerService.insert(cmsBanner);
			res.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("addCmsBanner error",e);
			res.setSuccess(false);
			response.setError(Constants.System.SYSTEM_ERROR_CODE);
			response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
		}
		response.setData(res);
		return response;
	}

	@Override
	public DubboResponse<CmsBannerResponse> updataCmsBanner(CmsBannerRequest request) {
		LOGGER.debug("updataCmsBanner,requestParam:{}",JSONObject.toJSONString(request));
		DubboResponse<CmsBannerResponse> response = new DubboResponse<CmsBannerResponse>();
		CmsBannerResponse res = new CmsBannerResponse();
		response.setError(Constants.System.SERVER_SUCCESS);
		response.setStatus(Constants.System.OK);
		String id = request.getId();
		if(StringUtils.isBlank(id)){
			response.setError(Constants.System.PARAMS_INVALID);
			response.setMsg(Constants.System.PARAMS_INVALID_MSG);
			return response;
		}
		try {
			CmsBanner cmsBanner = new CmsBanner();
			BeanUtils.copyOnPropertyUtils(cmsBanner, request);
			cmsBannerService.update(cmsBanner);
			res.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("updataCmsBanner error",e);
			res.setSuccess(false);
			response.setError(Constants.System.SYSTEM_ERROR_CODE);
			response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
		}
		response.setData(res);
		return response;
	}

	@Override
	public DubboResponse<CmsBannerResponse> deleteCmsBanner(DeleteCmsBannerRequest request) {
		LOGGER.debug("deleteCmsBanner,requestParam:{}",JSONObject.toJSONString(request));
		DubboResponse<CmsBannerResponse> response = new DubboResponse<CmsBannerResponse>();
		response.setError(Constants.System.SERVER_SUCCESS);
		response.setStatus(Constants.System.OK);
		String id = request.getId();
		if(StringUtils.isBlank(id)){
			response.setError(Constants.System.PARAMS_INVALID);
			response.setMsg(Constants.System.PARAMS_INVALID_MSG);
			return response;
		}
		CmsBannerResponse res = new CmsBannerResponse();
		try {
			CmsBanner cmsBanner = new CmsBanner();
			cmsBanner.setId(id);
			cmsBanner.setDeleteFlag(1);
			cmsBannerService.update(cmsBanner);
			res.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("deleteCmsBanner error",e);
			res.setSuccess(false);
			response.setError(Constants.System.SYSTEM_ERROR_CODE);
			response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
		}
		response.setData(res);
		return response;
	}

	@Override
	public DubboResponse<QueryCmsBannerResponse> queryCmsBanner(QueryCmsBannerRequest request) {
		LOGGER.debug("queryCmsBanner,requestParam:{}",JSONObject.toJSONString(request));
		DubboResponse<QueryCmsBannerResponse>  response = new  DubboResponse<QueryCmsBannerResponse>();
		response.setError(Constants.System.SERVER_SUCCESS);
		response.setStatus(Constants.System.OK);
		QueryCmsBannerResponse res = new QueryCmsBannerResponse();
		try {
			CmsBanner cmsBanner = new CmsBanner();
			BeanUtils.copyOnPropertyUtils(cmsBanner, request);
			cmsBanner.setDeleteFlag(0);
			List<CmsBanner> list = cmsBannerService.getByObj(cmsBanner);
			List<CmsBannerVo> voLists = new ArrayList<CmsBannerVo>();
			for(CmsBanner cb:list){
				if(cb==null){
					continue;
				}
				CmsBannerVo vo = new CmsBannerVo();
				BeanUtils.copyOnPropertyUtils(vo, cb);
				voLists.add(vo);
			}
			res.setList(voLists);
		} catch (Exception e) {
			LOGGER.error("queryCmsBanner error",e);
			response.setError(Constants.System.SYSTEM_ERROR_CODE);
			response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
		}
		response.setData(res);
		return response;
	}

}
