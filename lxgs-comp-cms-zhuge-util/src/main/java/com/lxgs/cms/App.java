package com.lxgs.cms;

import com.alibaba.fastjson.JSONObject;
import com.lxgs.cms.zhuge.config.ZhugeConfig;
import com.lxgs.cms.zhuge.util.ZhugeUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

//        System.out.println( "Hello World!" );
      String base1 = Base64.getEncoder().encodeToString((ZhugeConfig.appKey+":"+ZhugeConfig.secretKey).getBytes("UTF-8"));
      System.out.println(base1);
        URL url = new URL(ZhugeConfig.apiUrl);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
      connection.setRequestProperty("Authorization","Basic\t"+base1);
        connection.setDoOutput(true);
        connection.getOutputStream().write(
            "data=ewogICAgInRzIjogIjE0Mzc2Mzk1NzIiLAogICAgImN1aWQiOiAiaGVsbG9Aemh1Z2UuaW8iLAogICAgImFrIjogIjEyMzQ1Njc4OTAxMjM0NTYiLAogICAgInNkayI6ICJhbmQiLAogICAgImRhdGEiOiBbCiAgICAgICAgewogICAgICAgICAgICAiZXQiOiAiY3VzIiwKICAgICAgICAgICAgImVpZCI6ICJzaGFyZSIsCiAgICAgICAgICAgICJ0cyI6ICIxNDM3NjM5NTcyIiwKICAgICAgICAgICAgInByIjogewogICAgICAgICAgICAgICAgInByMSI6ICJ4eHh4IgogICAgICAgICAgICB9CiAgICAgICAgfSwKICAgICAgICB7CiAgICAgICAgICAgICJldCI6ICJjdXMiLAogICAgICAgICAgICAiZWlkIjogImNsaWNrIiwKICAgICAgICAgICAgInRzIjogIjE0Mzc2Mzk1NzIiLAogICAgICAgICAgICAicHIiOiB7CiAgICAgICAgICAgICAgICAicHIyIjogInh4eHgiCiAgICAgICAgICAgIH0KICAgICAgICB9CiAgICBdCn0="
                .getBytes("UTF-8"));
      BufferedReader
          bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
      StringBuilder result = new StringBuilder();
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        result.append(line).append("\n");
      }
connection.disconnect();
      System.out.print(result);

//      JSONObject jsonObject = new JSONObject();
//      String key = "dfb87d9e3e7a43189959f77789f3fd38:46051f26af7e4686b34c764b3e98a80b";
//      jsonObject.put("Authorization","dfb87d9e3e7a43189959f77789f3fd38:46051f26af7e4686b34c764b3e98a80b");
//      System.out.println(jsonObject.toJSONString());
//      System.out.println(ZhugeUtil.invoke("https://apipool.zhugeio.com/open/v1/event_statis_srv/upload_event",jsonObject));


    }



}
