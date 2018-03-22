package com.lxgs.cms.test;

import com.alibaba.fastjson.JSON;
import com.lxgs.cms.ZhugeService;
import com.lxgs.cms.dubbo.api.request.zhuge.EventPr;
import com.lxgs.cms.dubbo.api.request.zhuge.PersonPr;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugeEventData;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugeEventRequest;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugePersonData;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugePersonRequest;
import com.lxgs.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.dubbo.DubboResponse;

import org.junit.Test;

import java.util.Date;

import javax.annotation.Resource;

/**
* Created by yaojun on 2017/1/15.
*/
public class ZhugeTest extends BaseTest{

  @Resource
  private ZhugeService service;

  @Test
  public void RecordParam(){
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmm");
    String time = (new Date().getTime()+"").substring(0,10);
    //自定义事件
    ZhugeEventRequest eventRequest = new ZhugeEventRequest();
    eventRequest.setDebug(1);
    eventRequest.setTs(time);
    eventRequest.setCuid("hello@zhuge.io");
    //data中的per属性
    EventPr eventPer = new EventPr();
    //data属性值
    ZhugeEventData zhugeEventData = new ZhugeEventData();
      zhugeEventData.setTs(time);
    zhugeEventData.setEid("click");
    zhugeEventData.setPr(eventPer);
    eventRequest.setRequestId(BillNoUtils.GenerateBillNo());
    eventRequest.setData(new ZhugeEventData[]{zhugeEventData});
//用户per属性

    PersonPr personPer = new PersonPr();
    personPer.setName("hello");
    personPer.setMobile("18710002233");
    ZhugePersonData zhugePersonData = new ZhugePersonData();
    zhugePersonData.setTs(time);
    zhugePersonData.setCuid("hello@zhuge.io");
    zhugePersonData.setPr(personPer);
    //用户信息
    ZhugePersonRequest personRequest = new ZhugePersonRequest();
    personRequest.setCuid("hello@zhuge.io");
    personRequest.setTs(time);
    personRequest.setRequestId(BillNoUtils.GenerateBillNo());
    personRequest.setData(new ZhugePersonData[]{zhugePersonData});
//    System.out.println(personRequest);
//    System.out.println(eventRequest);
     DubboResponse<ZhugeResponse> response = service.RecordPerParams(personRequest);
      DubboResponse<ZhugeResponse> dubboResponse = service.RecordEventParams(eventRequest);
logger.debug("=================================personRequest\t" + response);
logger.debug("=================================eventRequest\t"+dubboResponse);
  }

}
