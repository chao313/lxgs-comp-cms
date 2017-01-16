package com.sdxd.cms.dubbo.impl;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.sdxd.cms.dubbo.api.ZhugeIODubboService;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugePersonRequest;
import com.sdxd.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.cms.zhuge.config.ZhugeConfig;
import com.sdxd.cms.zhuge.util.ZhugeUtil;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dubbo.DubboResponse;


/**
 * Created by yaojun on 2017/1/14.
 */
@Service(interfaceName = "com.sdxd.cms.dubbo.api.ZhugeIODubboService", validation = "true", version = "1.0.0", timeout = 30000)
public class ZhugeIODubboServiceImpl implements ZhugeIODubboService {
  private static final Logger logger = LoggerFactory.getLogger(ZhugeIODubboServiceImpl.class);

  @Override
  public DubboResponse<ZhugeResponse> RecordParams(ZhugeEventRequest request) {
    logger.debug("============================Zhuge开始ZhugeEventRequest");
    ZhugeResponse response = new ZhugeResponse();
    DubboResponse<ZhugeResponse> dubboResponse = new DubboResponse();
    dubboResponse.setError(Constants.System.SERVER_SUCCESS);
    dubboResponse.setStatus(Constants.System.OK);

    try{
      String json = JSON.toJSONString(request);
      response = ZhugeUtil.invoke(ZhugeConfig.apiUrl,json);
      dubboResponse.setData(response);
    }catch (Exception e){
      logger.debug("==========================出错了");
      logger.debug("=============================结果\t"+dubboResponse);
    }

    return dubboResponse;
  }

  @Override
  public DubboResponse<ZhugeResponse> RecordParams(ZhugePersonRequest request) {
    logger.debug("============================Zhuge开始ZhugePersonRequest");
    ZhugeResponse response = new ZhugeResponse();
    DubboResponse<ZhugeResponse> dubboResponse = new DubboResponse();
    dubboResponse.setError(Constants.System.SERVER_SUCCESS);
    dubboResponse.setStatus(Constants.System.OK);

    try{
      String json = JSON.toJSONString(request);
      response = ZhugeUtil.invoke(ZhugeConfig.apiUrl,json);
      dubboResponse.setData(response);
    }catch (Exception e){
      logger.debug("==========================出错了");
      logger.debug("=============================结果\t"+dubboResponse);
    }

    return dubboResponse;
  }

}
