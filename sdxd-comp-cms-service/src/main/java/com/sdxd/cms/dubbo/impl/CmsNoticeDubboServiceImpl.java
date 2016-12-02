package com.sdxd.cms.dubbo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.sdxd.cms.dubbo.api.CmsNoticeDubboService;
import com.sdxd.cms.dubbo.api.pojo.CmsNoticeVo;
import com.sdxd.cms.dubbo.api.request.CmsNoticeRequest;
import com.sdxd.cms.dubbo.api.response.CmsNoticeResponse;
import com.sdxd.cms.dubbo.api.response.QueryCmsNoticeResponse;
import com.sdxd.cms.entity.CmsNotice;
import com.sdxd.cms.service.CmsNoticeSerivce;
import com.sdxd.common.utils.BeanUtils;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dubbo.DubboResponse;

@Service(interfaceName = "com.sdxd.cms.dubbo.api.CmsNoticeDubboService", validation = "true", version = "1.0.0", timeout = 30000)
public class CmsNoticeDubboServiceImpl implements CmsNoticeDubboService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CmsNoticeDubboServiceImpl.class);
	
	@Resource
	private CmsNoticeSerivce cmsNoticeService;

	@Override
	public DubboResponse<CmsNoticeResponse> addCmsNotic(CmsNoticeRequest request) {
		LOGGER.debug("addCmsNotic,requestParam:{}",JSONObject.toJSONString(request));
		DubboResponse<CmsNoticeResponse> reponse = new DubboResponse<CmsNoticeResponse>();
		CmsNoticeResponse res = new CmsNoticeResponse();
		if(StringUtils.isBlank(request.getLink())||StringUtils.isBlank(request.getTitle())){
			res.setSuccess(false);
			reponse.setError(Constants.System.PARAMS_INVALID);
			reponse.setStatus(Constants.System.FAIL);
			return reponse;
		}
		reponse.setError(Constants.System.SERVER_SUCCESS);
		reponse.setStatus(Constants.System.OK);
		try {
			CmsNotice cmsNotice = new CmsNotice();
			BeanUtils.copyOnPropertyUtils(cmsNotice, request);
			cmsNoticeService.insert(cmsNotice);
			res.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("addCmsNotic error",e);
			res.setSuccess(false);
			reponse.setError(Constants.System.SYSTEM_ERROR_CODE);
			reponse.setStatus(Constants.System.FAIL);
		}
		reponse.setData(res);
		return reponse;
	}

	@Override
	public DubboResponse<CmsNoticeResponse> deleteCmsNotic(CmsNoticeRequest request) {
		LOGGER.debug("deleteCmsNotic,requestParam:{}",JSONObject.toJSONString(request));
		DubboResponse<CmsNoticeResponse> reponse = new DubboResponse<CmsNoticeResponse>();
		reponse.setError(Constants.System.SERVER_SUCCESS);
		reponse.setStatus(Constants.System.OK);
		String id = request.getId();
		if(StringUtils.isBlank(id)){
			reponse.setError(Constants.System.PARAMS_INVALID);
			reponse.setStatus(Constants.System.FAIL);
			return reponse;
		}
		CmsNoticeResponse res = new CmsNoticeResponse();
		try {
			CmsNotice cmsNotice = new CmsNotice();
			cmsNotice.setId(id);
			cmsNotice.setDeleteFlag(1);
			cmsNoticeService.update(cmsNotice);
			res.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("deleteCmsNotic error",e);
			res.setSuccess(false);
			reponse.setError(Constants.System.SYSTEM_ERROR_CODE);
			reponse.setStatus(Constants.System.FAIL);
		}
		reponse.setData(res);
		return reponse;
	}

	@Override
	public DubboResponse<CmsNoticeResponse> updataCmsNotic(CmsNoticeRequest request) {
		LOGGER.debug("updataCmsNotic,requestParam:{}",JSONObject.toJSONString(request));
		DubboResponse<CmsNoticeResponse> reponse = new DubboResponse<CmsNoticeResponse>();
		CmsNoticeResponse res = new CmsNoticeResponse();
		reponse.setError(Constants.System.SERVER_SUCCESS);
		reponse.setStatus(Constants.System.OK);
		String id = request.getId();
		if(StringUtils.isBlank(id)){
			reponse.setError(Constants.System.PARAMS_INVALID);
			reponse.setStatus(Constants.System.FAIL);
			return reponse;
		}
		try {
			CmsNotice cmsNotice = new CmsNotice();
			BeanUtils.copyOnPropertyUtils(cmsNotice, request);
			cmsNoticeService.update(cmsNotice);
			res.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("updataCmsNotic error",e);
			res.setSuccess(false);
			reponse.setError(Constants.System.SYSTEM_ERROR_CODE);
			reponse.setStatus(Constants.System.FAIL);
		}
		reponse.setData(res);
		return reponse;
	}

	@Override
	public DubboResponse<QueryCmsNoticeResponse> queryCmsNotic(CmsNoticeRequest request) {
		LOGGER.debug("queryCmsNotic,requestParam:{}",JSONObject.toJSONString(request));
		DubboResponse<QueryCmsNoticeResponse>  reponse = new  DubboResponse<QueryCmsNoticeResponse>();
		reponse.setError(Constants.System.SERVER_SUCCESS);
		reponse.setStatus(Constants.System.OK);
		QueryCmsNoticeResponse res = new QueryCmsNoticeResponse();
		try {
			CmsNotice cmsNotice = new CmsNotice();
			BeanUtils.copyOnPropertyUtils(cmsNotice, request);
			cmsNotice.setDeleteFlag(0);
			List<CmsNotice> list = cmsNoticeService.findByObj(cmsNotice);
			List<CmsNoticeVo> voLists = new ArrayList<CmsNoticeVo>();
			for(CmsNotice cn:list){
				if(cn==null){
					continue;
				}
				CmsNoticeVo vo = new CmsNoticeVo();
				BeanUtils.copyOnPropertyUtils(vo, cn);
				voLists.add(vo);
			}
			res.setList(voLists);
		} catch (Exception e) {
			LOGGER.error("queryCmsNotic error",e);
			reponse.setError(Constants.System.SYSTEM_ERROR_CODE);
			reponse.setStatus(Constants.System.FAIL);
		}
		reponse.setData(res);
		return reponse;
	}
	
	
}
