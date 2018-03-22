package com.lxgs.cms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lxgs.cms.dubbo.api.request.zhuge.EventPr;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugeEventRequest;
import com.lxgs.cms.dubbo.api.request.zhuge.PersonPr;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugePersonRequest;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugeEventData;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugePersonData;
import com.lxgs.cms.dubbo.api.response.ZhugeResponse;
import com.lxgs.cms.zhuge.config.ZhugeConfig;
import com.lxgs.cms.zhuge.util.ZhugeUtil;
import com.sdxd.common.utils.BillNoUtils;

import org.junit.Test;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Create the test case
     */
    @Test
    public void AppTest()
    {
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
      personRequest.setAk(ZhugeConfig.appKey);
      eventRequest.setAk(ZhugeConfig.appKey);
      String json = JSON.toJSONString(eventRequest);
//      json = JSONObject.parseObject(json).remove("requestId").toString();
      String key = ZhugeUtil.setKey(ZhugeConfig.appKey,ZhugeConfig.secretKey);
      String test = "{\"cuid\":\"hello@zhuge.io\",\"data\":[{\"eid\":\"click\",\"et\":\"cus\",\"pr\":{},\"ts\":\"1484823139\"}],\"debug\":1,\"sdk\":\"web\",\"ts\":\"1484823139\"}";
      ZhugeResponse response = ZhugeUtil.invoke(ZhugeConfig.apiUrl, json,key);
        System.out.println(test);
      System.out.println(key);
//        JSONObject jsonObject = JSONObject.parseObject(json);
//      jsonObject.put("data","["+jsonObject.getString("eventRequest")+","+jsonObject.getString("personRequest")+"]");

//      array.add(jsonObject.get("personRequest"));
//      array.add(jsonObject.get("eventRequest"));
//      System.out.println(jsonObject.toJSONString());
//        ZhugeResponse response = ZhugeUtil.invoke(ZhugeConfig.apiUrl, jsonObject);
//      for (int i = 0; i < 50; i++) {
//        ZhugeResponse response = ZhugeUtil.invoke(ZhugeConfig.apiUrl, json);
//        System.out.println(response);
//      }

//        ZhugeResponse response2 = ZhugeUtil.invoke(ZhugeConfig.apiUrl, json1);
//        System.out.println(response2);

//      for(Map.Entry set : jsonObject.entrySet()){
//        System.out.println(set.getKey());
//        System.out.println(set.getValue());
//      }
    }

  @Test
  public void close(){
    try {
//      URL url = new URL(ZhugeConfig.apiUrl);
//      HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//      connection.connect();
//      connection.disconnect();

//      connection.setDoOutput(true);

//      String text = "W3siY3VpZCI6ImhlbGxvQHpodWdlLmlvIiwiZGF0YSI6W3siY3VpZCI6ImhlbGxvQHpodWdlLmlvIiwicGVyIjp7Im1vYmlsZSI6IjE4NzEwMDAyMjMzIiwibmFtZSI6ImhlbGxvIn0sImV0IjoiaWRmIiwidHMiOiIxNzAxMTUxMzExIn1dLCJhayI6ImRmYjg3ZDllM2U3YTQzMTg5OTU5Zjc3Nzg5ZjNmZDM4Iiwic2RrIjoid2ViIiwidHMiOiIxNzAxMTUxMzExIn0seyJjdWlkIjoiaGVsbG9Aemh1Z2UuaW8iLCJkZWJ1ZyI6MSwiZGF0YSI6W3siZWlkIjoiY2xpY2siLCJwZXIiOnt9LCJldCI6ImN1cyIsInRzIjoiMTcwMTE1MTMxMSJ9XSwiYWsiOiJkZmI4N2Q5ZTNlN2E0MzE4OTk1OWY3Nzc4OWYzZmQzOCIsInNkayI6IndlYiIsInRzIjoiMTcwMTE1MTMxMSJ9XQ==";
//      byte[] get = Base64.getDecoder().decode(text);
//      System.out.println(get[1]);

//      JSONObject jsonObject = new JSONObject();
//      jsonObject.put("Authorization","dfb87d9e3e7a43189959f77789f3fd38:46051f26af7e4686b34c764b3e98a80b");
//      ZhugeResponse response = ZhugeUtil.invoke(ZhugeConfig.apiUrl, jsonObject);
//      System.out.println(response);
      System.out.println(ZhugeUtil.getTime(
          new Date()
      ));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
