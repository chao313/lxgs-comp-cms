package com.sdxd.cms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sdxd.cms.dubbo.api.request.zhuge.EventPer;
import com.sdxd.cms.dubbo.api.request.zhuge.EventRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.PersonPer;
import com.sdxd.cms.dubbo.api.request.zhuge.PersonRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeDataRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventData;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugePersonData;
import com.sdxd.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.cms.zhuge.config.ZhugeConfig;
import com.sdxd.cms.zhuge.util.ZhugeUtil;
import com.sdxd.common.utils.BillNoUtils;


import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmm");
        //自定义事件
        EventRequest eventRequest = new EventRequest();
        eventRequest.setDebug(1);
        eventRequest.setTs(dateFormat.format(Calendar.getInstance().getTime()));
        eventRequest.setCuid("hello@zhuge.io");
        //data中的per属性
        EventPer eventPer = new EventPer();
        //data属性值
        ZhugeEventData<EventPer> zhugeEventData = new ZhugeEventData<>();
        zhugeEventData.setTs(dateFormat.format(Calendar.getInstance().getTime()));
        zhugeEventData.setEid("click");
        zhugeEventData.setPer(eventPer);
        eventRequest.setData(new ZhugeEventData[]{zhugeEventData});
//用户per属性

        PersonPer personPer = new PersonPer();
        personPer.setName("hello");
        personPer.setMobile("18710002233");
        ZhugePersonData<PersonPer> zhugePersonData = new ZhugePersonData<>();
        zhugePersonData.setTs(dateFormat.format(Calendar.getInstance().getTime()));
        zhugePersonData.setCuid("hello@zhuge.io");
        zhugePersonData.setPer(personPer);
        //用户信息
        PersonRequest personRequest = new PersonRequest();
        personRequest.setCuid("hello@zhuge.io");
        personRequest.setTs(dateFormat.format(Calendar.getInstance().getTime()));
        personRequest.setData(new ZhugePersonData[]{zhugePersonData});

        ZhugeDataRequest request = new ZhugeDataRequest();
        request.setEventRequest(eventRequest);
        request.setPersonRequest(personRequest);
        request.setRequestId(BillNoUtils.GenerateBillNo());

        String json = JSON.toJSONString(request);
        System.out.println(json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        jsonObject.put("Authorization","dfb87d9e3e7a43189959f77789f3fd38:46051f26af7e4686b34c764b3e98a80b");
//      jsonObject.put("data","["+jsonObject.getString("eventRequest")+","+jsonObject.getString("personRequest")+"]");

      JSONArray array = new JSONArray();
      array.add(jsonObject.get("personRequest"));
      array.add(jsonObject.get("eventRequest"));
      jsonObject.remove("personRequest");
      jsonObject.remove("eventRequest");
      jsonObject.put("data",array);
      System.out.println(jsonObject.toJSONString());
//        ZhugeResponse response = ZhugeUtil.invoke(ZhugeConfig.apiUrl, jsonObject);
        ZhugeResponse response = ZhugeUtil.invoke(ZhugeConfig.apiUrl, request);
        System.out.println(response);

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

      JSONObject jsonObject = new JSONObject();
      jsonObject.put("Authorization","dfb87d9e3e7a43189959f77789f3fd38:46051f26af7e4686b34c764b3e98a80b");
      ZhugeResponse response = ZhugeUtil.invoke(ZhugeConfig.apiUrl, jsonObject);
      System.out.println(response);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
