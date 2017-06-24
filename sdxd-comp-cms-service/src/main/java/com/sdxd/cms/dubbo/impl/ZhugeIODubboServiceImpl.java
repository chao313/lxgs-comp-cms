package com.sdxd.cms.dubbo.impl;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.sdxd.admin.dubbo.api.response.SystemVariableResponse;
import com.sdxd.cms.constants.ZhuGeVar;
import com.sdxd.cms.dubbo.api.ZhugeIODubboService;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugePersonRequest;
import com.sdxd.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.cms.dubbo.outApi.OutApiCustomer;
import com.sdxd.cms.zhuge.util.ZhugeUtil;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dubbo.DubboResponse;

import javax.annotation.Resource;


/**
 * Created by yaojun on 2017/1/14.
 */
@Service(interfaceName = "com.sdxd.cms.dubbo.api.ZhugeIODubboService", validation = "true", version = "1.0.0", timeout = 30000)
public class ZhugeIODubboServiceImpl implements ZhugeIODubboService {
  private static final Logger logger = LoggerFactory.getLogger(ZhugeIODubboServiceImpl.class);

  @Resource
  private OutApiCustomer customer;


  @Override
  public DubboResponse<ZhugeResponse> RecordEventParams(ZhugeEventRequest request) {
    logger.debug("============================Zhuge开始ZhugeEventRequest");
    ZhugeResponse response = null ;
    DubboResponse<ZhugeResponse> dubboResponse = new DubboResponse();
    dubboResponse.setError(Constants.System.SERVER_SUCCESS);
    dubboResponse.setStatus(Constants.System.OK);

    try{
      String apiUrl = customer.getZhugeParam(ZhuGeVar.ZHUGE_API_URL.getCode());
      String appKey = customer.getZhugeParam(ZhuGeVar.ZHUGE_API_APPKEY.getCode());
      String secretKey = customer.getZhugeParam(ZhuGeVar.ZHUGE_API_SECRETKEY.getCode());
      request.setAk(appKey);
      String json = JSON.toJSONString(request);
      String keys = ZhugeUtil.setKey(appKey,secretKey);
      response = ZhugeUtil.invoke(apiUrl,json,keys);
      dubboResponse.setData(response);
      logger.debug("=============================结果{}\t"+dubboResponse);
    }catch (Exception e){
      logger.debug("==========================出错了{}",e);
      logger.debug("=============================结果{}\t"+dubboResponse);
    }

    return dubboResponse;
  }

  @Override
  public DubboResponse<ZhugeResponse> RecordPerParams(ZhugePersonRequest request) {
    logger.debug("============================Zhuge开始ZhugePersonRequest");
    ZhugeResponse response = null ;
    DubboResponse<ZhugeResponse> dubboResponse = new DubboResponse();
    dubboResponse.setError(Constants.System.SERVER_SUCCESS);
    dubboResponse.setStatus(Constants.System.OK);

    try{
      String apiUrl = customer.getZhugeParam(ZhuGeVar.ZHUGE_API_URL.getCode());
      String appKey = customer.getZhugeParam(ZhuGeVar.ZHUGE_API_APPKEY.getCode());
      String secretKey = customer.getZhugeParam(ZhuGeVar.ZHUGE_API_SECRETKEY.getCode());
      request.setAk(appKey);
      String json = JSON.toJSONString(request);
      String keys = ZhugeUtil.setKey(appKey,secretKey);

      response = ZhugeUtil.invoke(apiUrl,json,keys);
      dubboResponse.setData(response);
      logger.debug("=============================结果{}\t"+dubboResponse);
    }catch (Exception e){
      logger.debug("==========================出错了{}",e);
      logger.debug("=============================结果{}\t"+dubboResponse);
    }

    return dubboResponse;
  }

}
