package com.sdxd.cms.test;

import com.alibaba.fastjson.JSON;
import com.sdxd.cms.ZhugeService;
import com.sdxd.cms.dubbo.api.request.zhuge.EventPer;
import com.sdxd.cms.dubbo.api.request.zhuge.EventRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.PersonPer;
import com.sdxd.cms.dubbo.api.request.zhuge.PersonRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeDataRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventData;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugePersonData;
import com.sdxd.common.utils.BillNoUtils;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

/**
 * Created by yaojun on 2017/1/15.
 */
public class ZhugeTest {

  @Resource
  private ZhugeService service;

  @Test
  public void RecordParam(){
    //自定义事件
    EventRequest eventRequest = new EventRequest();
    eventRequest.setDebug(1);
    eventRequest.setTs(new Date().getTime());
    eventRequest.setCuid("hello@zhuge.io");
    //data中的per属性
    EventPer eventPer = new EventPer();
    //data属性值
    ZhugeEventData<EventPer> zhugeEventData = new ZhugeEventData<>();
    zhugeEventData.setTs(new Date().getTime());
    zhugeEventData.setEid("click");
    zhugeEventData.setPer(eventPer);
    eventRequest.setData(new ZhugeEventData[]{zhugeEventData});
//用户per属性

    PersonPer personPer = new PersonPer();
    personPer.setName("hello");
    personPer.setMobile("18710002233");
    ZhugePersonData<PersonPer> zhugePersonData = new ZhugePersonData<>();
    zhugePersonData.setTs(new Date().getTime());
    zhugePersonData.setCuid("hello@zhuge.io");
    zhugePersonData.setPer(personPer);
    //用户信息
    PersonRequest personRequest = new PersonRequest();
    personRequest.setCuid("hello@zhuge.io");
    personRequest.setTs(new Date().getTime());
    personRequest.setData(new ZhugePersonData[]{zhugePersonData});

    ZhugeDataRequest request = new ZhugeDataRequest();
    request.setEventRequest(eventRequest);
    request.setPersonRequest(personRequest);
    request.setRequestId(BillNoUtils.GenerateBillNo());

    String json = JSON.toJSONString(request);
    System.out.println(json);
  }

}
