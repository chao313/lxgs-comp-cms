package com.sdxd.cms.dubbo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.sdxd.cms.dubbo.api.request.CmstomNoticeRequest;
import com.sdxd.cms.utils.TransformUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdxd.cms.dubbo.api.CmsNoticeDubboService;
import com.sdxd.cms.dubbo.api.pojo.CmsNoticeVo;
import com.sdxd.cms.dubbo.api.request.CmsNoticeRequest;
import com.sdxd.cms.dubbo.api.response.CmsNoticeResponse;
import com.sdxd.cms.dubbo.api.response.QueryCmsNoticeResponse;
import com.sdxd.cms.entity.CmsNotice;
import com.sdxd.cms.service.CmsNoticeSerivce;
import com.sdxd.common.redis.template.RedisClientTemplate;
import com.sdxd.common.utils.BeanUtils;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dubbo.DubboResponse;

@Service(interfaceName = "com.sdxd.cms.dubbo.api.CmsNoticeDubboService", validation = "true", version = "1.0.0", timeout = 30000)
public class CmsNoticeDubboServiceImpl implements CmsNoticeDubboService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsNoticeDubboServiceImpl.class);

    @Resource
    private CmsNoticeSerivce cmsNoticeService;

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    private String REDIS_KEY_LIST = "SDXD:CMS:NOTICE:LIST";

    @Override
    public DubboResponse<CmsNoticeResponse> addCmsNotic(CmsNoticeRequest request) {
        LOGGER.debug("addCmsNotic,requestParam:{}", JSONObject.toJSONString(request));
        DubboResponse<CmsNoticeResponse> response = new DubboResponse<CmsNoticeResponse>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);
        CmsNoticeResponse res = new CmsNoticeResponse();
        if (StringUtils.isBlank(request.getTitle())) {
            res.setSuccess(false);
            response.setError(Constants.System.PARAMS_INVALID);
            response.setMsg(Constants.System.PARAMS_INVALID_MSG);
            return response;
        }
        try {
            CmsNotice cmsNotice = new CmsNotice();
            BeanUtils.copyOnPropertyUtils(cmsNotice, request);
            cmsNoticeService.insert(cmsNotice);
            res.setSuccess(true);

            redisClientTemplate.del(REDIS_KEY_LIST);
        } catch (Exception e) {
            LOGGER.error("addCmsNotic error", e);
            res.setSuccess(false);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        response.setData(res);
        return response;
    }

    @Override
    public DubboResponse<CmsNoticeResponse> deleteCmsNotic(CmsNoticeRequest request) {
        LOGGER.debug("deleteCmsNotic,requestParam:{}", JSONObject.toJSONString(request));
        DubboResponse<CmsNoticeResponse> response = new DubboResponse<CmsNoticeResponse>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);
        String id = request.getId();
        if (StringUtils.isBlank(id)) {
            response.setError(Constants.System.PARAMS_INVALID);
            response.setMsg(Constants.System.PARAMS_INVALID_MSG);
            return response;
        }
        CmsNoticeResponse res = new CmsNoticeResponse();
        try {
            CmsNotice cmsNotice = new CmsNotice();
            cmsNotice.setId(id);
            cmsNotice.setDeleteFlag(1);
            cmsNoticeService.update(cmsNotice);
            res.setSuccess(true);

            redisClientTemplate.del(REDIS_KEY_LIST);
        } catch (Exception e) {
            LOGGER.error("deleteCmsNotic error", e);
            res.setSuccess(false);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        response.setData(res);
        return response;
    }

    @Override
    public DubboResponse<CmsNoticeResponse> updataCmsNotic(CmsNoticeRequest request) {
        LOGGER.debug("updataCmsNotic,requestParam:{}", JSONObject.toJSONString(request));
        DubboResponse<CmsNoticeResponse> response = new DubboResponse<CmsNoticeResponse>();
        CmsNoticeResponse res = new CmsNoticeResponse();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);
        String id = request.getId();
        if (StringUtils.isBlank(id)) {
            response.setError(Constants.System.PARAMS_INVALID);
            response.setMsg(Constants.System.PARAMS_INVALID_MSG);
            return response;
        }
        try {
            CmsNotice cmsNotice = new CmsNotice();
            BeanUtils.copyOnPropertyUtils(cmsNotice, request);
            cmsNoticeService.update(cmsNotice);
            res.setSuccess(true);

            redisClientTemplate.del(REDIS_KEY_LIST);
        } catch (Exception e) {
            LOGGER.error("updataCmsNotic error", e);
            res.setSuccess(false);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        response.setData(res);
        return response;
    }

    @Override
    public DubboResponse<QueryCmsNoticeResponse> queryCmsNotic(CmsNoticeRequest request) {
        LOGGER.debug("queryCmsNotic,requestParam:{}", JSONObject.toJSONString(request));
        DubboResponse<QueryCmsNoticeResponse> response = new DubboResponse<QueryCmsNoticeResponse>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);
        QueryCmsNoticeResponse res = new QueryCmsNoticeResponse();


        List<CmsNoticeVo> voLists = null;
        try {
            String noticesInRedis = redisClientTemplate.get(REDIS_KEY_LIST);
            if (!StringUtils.isEmpty(noticesInRedis)) {
                voLists = JSON.parseArray(noticesInRedis, CmsNoticeVo.class);
            }
        } catch (Exception e) {
            LOGGER.error("Query notice list in redis error", e);
        }


        try {
            if (voLists == null) {
                voLists = new ArrayList<CmsNoticeVo>();

                CmsNotice cmsNotice = new CmsNotice();
                BeanUtils.copyOnPropertyUtils(cmsNotice, request);
                cmsNotice.setDeleteFlag(0);
                List<CmsNotice> list = cmsNoticeService.getByObj(cmsNotice);
                for (CmsNotice cn : list) {
                    if (cn == null) {
                        continue;
                    }
                    CmsNoticeVo vo = new CmsNoticeVo();
                    BeanUtils.copyOnPropertyUtils(vo, cn);
                    voLists.add(vo);
                }

                LOGGER.info("Put notice list into redis.");
                redisClientTemplate.set(REDIS_KEY_LIST, JSON.toJSONString(voLists));
                redisClientTemplate.expire(REDIS_KEY_LIST, 1 * 60 * 60);
            } else {
                LOGGER.info("Find notice list in redis.");
            }
        } catch (Exception e) {
            LOGGER.error("queryCmsNotic error", e);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }

        res.setList(voLists);
        response.setData(res);
        return response;
    }

    @Override
    public DubboResponse<QueryCmsNoticeResponse> queryCmsNoticeStatus(CmstomNoticeRequest request) {
        DubboResponse<QueryCmsNoticeResponse> response = new DubboResponse<>();
        QueryCmsNoticeResponse res = new QueryCmsNoticeResponse();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        Boolean status = request.getStatus();
        if (null == status) {
            response.setError(Constants.System.PARAMS_INVALID);
            response.setMsg(Constants.System.PARAMS_INVALID_MSG);
            return response;
        }
        try {
            List<CmsNotice> list = null;
            if (true == status) {
                list = cmsNoticeService.getAllOnline();
            } else {
                list = cmsNoticeService.getAllNotice();
            }
            List<CmsNoticeVo> list1 = TransformUtil.toList(list, CmsNoticeVo.class);
            res.setList(list1);
        } catch (Exception e) {
            LOGGER.error("queryCmsNoticeStatus error", e);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        response.setData(res);
        return response;
    }
}


