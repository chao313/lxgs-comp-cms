package com.sdxd.cms.dubbo.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
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
import com.sdxd.common.redis.template.RedisClientTemplate;
import com.sdxd.common.utils.BeanUtils;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dubbo.DubboResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Service(interfaceName = "com.sdxd.cms.dubbo.api.CmsBannerDubboService", validation = "true", version = "1.0.0", timeout = 30000)
public class CmsBannerDubboServiceImpl implements CmsBannerDubboService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CmsBannerDubboServiceImpl.class);
	@Resource
	private CmsBannerService cmsBannerService;

	@Autowired
	private RedisClientTemplate redisClientTemplate;

	private String REDIS_KEY_LIST="SDXD:CMS:BANNER:LIST";


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

			clearBannerValue(request.getType());
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

			clearBannerValue(request.getType());
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
			cmsBanner = cmsBannerService.getById(id);
			cmsBanner.setDeleteFlag(1);
			cmsBannerService.update(cmsBanner);
			res.setSuccess(true);
			clearBannerValue(cmsBanner.getType());
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

		//TODO 临时
		/*if(StringUtils.isBlank(request.getType())){
			request.setType(CmsBannerType.APP.toString());
		}*/
		
		List<CmsBannerVo> voLists = null;
		try {
			String bannersInRedis = getBannerValue(request.getType());
			if(!StringUtils.isEmpty(bannersInRedis)) {
				voLists = JSON.parseArray(bannersInRedis, CmsBannerVo.class);
            }
		} catch (Exception e) {
			LOGGER.error("Query banner list in redis error",e);
		}
		

		try {
			if(voLists==null) {
				//从数据库查询，并保存到redis数据库
				voLists = new ArrayList<>();
				CmsBanner cmsBanner = new CmsBanner();
				BeanUtils.copyOnPropertyUtils(cmsBanner, request);
				cmsBanner.setDeleteFlag(0);
				List<CmsBanner> list = cmsBannerService.getByObj(cmsBanner);
				if(CollectionUtils.isNotEmpty(list)){
					for (CmsBanner cb : list) {
						if (cb == null) {
							continue;
						}
						CmsBannerVo vo = new CmsBannerVo();
						BeanUtils.copyOnPropertyUtils(vo, cb);
						voLists.add(vo);
					}
					voLists.sort(new Comparator<CmsBannerVo>() {
						@Override
						public int compare(CmsBannerVo o1, CmsBannerVo o2) {
							if(o1==null||o2==null){
								return 0;
							}
							return o1.getImageOrder()-o2.getImageOrder();
						}
					});
				}
				LOGGER.info("Put banner list into redis.");
				refreshBannerValue(request.getType(), JSON.toJSONString(voLists));
			}else {
				LOGGER.info("Find banner list in redis.");
			}
		} catch (Exception e) {
			LOGGER.error("queryCmsBanner error",e);
			response.setError(Constants.System.SYSTEM_ERROR_CODE);
			response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
		}
		
		res.setList(voLists);
		response.setData(res);
		return response;
	}

	private String getBannerValue(String bannerType) {
		String type = StringUtils.isBlank(bannerType) ? "ALL" : bannerType;
		return redisClientTemplate.get(String.format("%s:%s", REDIS_KEY_LIST, type));
	}

	private void refreshBannerValue(String bannerType, String value) {
		String type = StringUtils.isBlank(bannerType) ? "ALL" : bannerType;
		String key = String.format("%s:%s", REDIS_KEY_LIST, type);
		redisClientTemplate.set(key, value);
		redisClientTemplate.expire(key, 60 * 60);
	}

	private void clearBannerValue(String bannerType) {
		redisClientTemplate.del(String.format("%s:%s", REDIS_KEY_LIST, bannerType));
		redisClientTemplate.del(String.format("%s:%s", REDIS_KEY_LIST, "ALL"));
	}
}
