package com.sdxd.cms.dubbo.impl;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.sdxd.cms.dubbo.api.ZhugeIODubboService;
import com.sdxd.cms.dubbo.api.request.zhuge.EventPr;
import com.sdxd.cms.dubbo.api.request.zhuge.PersonPr;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventData;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugePersonData;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugePersonRequest;
import com.sdxd.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.cms.zhuge.config.ZhugeConfig;
import com.sdxd.cms.zhuge.util.ZhugeUtil;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dubbo.DubboResponse;

import java.text.SimpleDateFormat;
import java.util.Date;


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

  public static void main(String [] args){
    ZhugeIODubboService zhugeIODubboService = new ZhugeIODubboServiceImpl();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmm");
    //自定义事件
    ZhugeEventRequest eventRequest = new ZhugeEventRequest();
    eventRequest.setDebug(1);
    eventRequest.setTs(dateFormat.format(new Date()));
    eventRequest.setCuid("hello@zhuge.io");
    //data中的per属性
    EventPr eventPer = new EventPr();
    //data属性值
    ZhugeEventData<EventPr> zhugeEventData = new ZhugeEventData<>();
    zhugeEventData.setTs(dateFormat.format(new Date()));
    zhugeEventData.setEid("click");
    zhugeEventData.setPr(eventPer);
    eventRequest.setRequestId(BillNoUtils.GenerateBillNo());
    eventRequest.setData(new ZhugeEventData[]{zhugeEventData});
//用户per属性

    PersonPr personPer = new PersonPr();
    personPer.setName("hello");
    personPer.setMobile("18710002233");
    ZhugePersonData<PersonPr> zhugePersonData = new ZhugePersonData<>();
    zhugePersonData.setTs(dateFormat.format(new Date()));
    zhugePersonData.setCuid("hello@zhuge.io");
    zhugePersonData.setPr(personPer);
    //用户信息
    ZhugePersonRequest personRequest = new ZhugePersonRequest();
    personRequest.setCuid("hello@zhuge.io");
    personRequest.setTs(dateFormat.format(new Date()));
    personRequest.setRequestId(BillNoUtils.GenerateBillNo());
    personRequest.setData(new ZhugePersonData[]{zhugePersonData});
//    System.out.println(personRequest);
//    System.out.println(eventRequest);
    zhugeIODubboService.RecordParams(eventRequest);
    zhugeIODubboService.RecordParams(personRequest);
  }

}
