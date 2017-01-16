package com.sdxd.cms.test;

import com.sdxd.cms.ZhugeService;
import com.sdxd.cms.dubbo.api.request.zhuge.EventPer;
import com.sdxd.cms.dubbo.api.request.zhuge.PersonPer;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventData;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugePersonData;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugePersonRequest;
import com.sdxd.common.utils.BillNoUtils;

import org.junit.Test;

import java.text.SimpleDateFormat;
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
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmm");
    //自定义事件
    ZhugeEventRequest eventRequest = new ZhugeEventRequest();
    eventRequest.setDebug(1);
    eventRequest.setTs(dateFormat.format(new Date()));
    eventRequest.setCuid("hello@zhuge.io");
    //data中的per属性
    EventPer eventPer = new EventPer();
    //data属性值
    ZhugeEventData<EventPer> zhugeEventData = new ZhugeEventData<>();
    zhugeEventData.setTs(dateFormat.format(new Date()));
    zhugeEventData.setEid("click");
    zhugeEventData.setPer(eventPer);
    eventRequest.setRequestId(BillNoUtils.GenerateBillNo());
    eventRequest.setData(new ZhugeEventData[]{zhugeEventData});
//用户per属性

    PersonPer personPer = new PersonPer();
    personPer.setName("hello");
    personPer.setMobile("18710002233");
    ZhugePersonData<PersonPer> zhugePersonData = new ZhugePersonData<>();
    zhugePersonData.setTs(dateFormat.format(new Date()));
    zhugePersonData.setCuid("hello@zhuge.io");
    zhugePersonData.setPer(personPer);
    //用户信息
    ZhugePersonRequest personRequest = new ZhugePersonRequest();
    personRequest.setCuid("hello@zhuge.io");
    personRequest.setTs(dateFormat.format(new Date()));
    personRequest.setRequestId(BillNoUtils.GenerateBillNo());
    personRequest.setData(new ZhugePersonData[]{zhugePersonData});
//    System.out.println(personRequest);
//    System.out.println(eventRequest);
    service.RecordParams(personRequest);
    service.RecordParams(eventRequest);

  }

}
