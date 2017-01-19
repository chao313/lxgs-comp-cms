package com.sdxd.cms.zhuge.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdxd.cms.dubbo.api.response.ZhugeResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Date;


/**
 * Created by yaojun on 2017/1/14.
 */
public class ZhugeUtil {

//  public static ZhugeResponse invoke(String apiUrl,JSONObject jsonObject) {
//    ZhugeResponse response = null;
//    //验证
//    String key = null;
//    try {
//      key =
//          Base64.getEncoder().encodeToString((ZhugeConfig.appKey+":"+ZhugeConfig.secretKey).getBytes("UTF-8"));
//    } catch (UnsupportedEncodingException e) {
//      e.printStackTrace();
//    }
//
//    URL url = null;
//    HttpURLConnection connection = null;
//    try {
//      url = new URL(apiUrl);
//      connection = (HttpURLConnection)url.openConnection();
//      // 设置长链接
//      connection.setRequestProperty("Connection", "Keep-Alive");
//      //连接超时3000毫秒
//      connection.setConnectTimeout(1000);
//      //读取超时3000毫秒
//      connection.setReadTimeout(500);
//      //连接方式
//      connection.setRequestMethod("POST");
//      connection.setUseCaches(false);
//      //存在http头
//      connection.setRequestProperty("Authorization","Basic "+key);
//      //移除验证消息,只要参数
//      jsonObject.remove("Authorization");
//      String param = Base64.getEncoder().encodeToString(
//          jsonObject.getString("data").getBytes("UTF-8"));
//      JSONObject object = new JSONObject();
////      object.put("data",Base64.getEncoder().encodeToString(jsonObject.get("eventRequest").toString().getBytes("UTF-8")));
//    object.put("data", param);
//
//      connection.setDoOutput(true);
//      //写入参数
//      connection.getOutputStream().write(object.toJSONString().getBytes());
//      connection.getOutputStream().flush();
//      if(connection.getResponseCode() == 200) {
//        response =  new ZhugeResponse();
//        BufferedReader
//            bufferedReader =
//            new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
//        StringBuilder result = new StringBuilder();
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//          result.append(line).append("\n");
//          System.out.println(result);
//        }
//        JSONObject json = JSON.parseObject(new String(result));
//        response.setReturnCode(json.getInteger("return_code"));
//        response.setReturnMessage(json.getString("return_message"));
//        bufferedReader.close();
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    }finally {
//      if(connection != null)
//      connection.disconnect();
//    }
//    return response;
//  }

  /**
   *
   * @param apiUrl 地址
   * @param params 参数的JSON字符串
   * @param keys 校验  appKey:secretKey
   * @return
   */

  public static ZhugeResponse invoke(String apiUrl,String params,String keys) {

    ZhugeResponse response = null;
    //验证
    String key = null;
    URL url = null;
    HttpURLConnection connection = null;
    try {
      key =
          Base64.getEncoder().encodeToString(keys.getBytes("UTF-8"));
//      url = new URL("http://localhost:8080/Zhuge/Test");
      url = new URL(apiUrl);
      connection = (HttpURLConnection)url.openConnection();
      // 设置长链接
      connection.setRequestProperty("Connection", "Keep-Alive");
      //连接超时3000毫秒
      connection.setConnectTimeout(1000);
      //读取超时3000毫秒
      connection.setReadTimeout(500);
      //连接方式
      connection.setRequestMethod("POST");
      connection.setUseCaches(false);
      //存在http头
      connection.setRequestProperty("Authorization", "Basic " + key);
//      String param = Base64.getEncoder().encodeToString(
//          jsonObject.getString("data").getBytes("UTF-8"));
      String param = Base64.getEncoder().encodeToString(
          params.getBytes("UTF-8"));
//      JSONObject object = new JSONObject();
//      object.put("data",Base64.getEncoder().encodeToString(jsonObject.get("eventRequest").toString().getBytes("UTF-8")));
//    object.put("data", param);

      connection.setDoOutput(true);
      //写入参数
      connection.getOutputStream().write(("data="+param).getBytes());
      connection.getOutputStream().flush();
      if(connection.getResponseCode() == 200) {
        response =  new ZhugeResponse();
        BufferedReader
            bufferedReader =
            new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
          result.append(line).append("\n");
          System.out.println(result);
        }
        JSONObject json = JSON.parseObject(new String(result));
        response.setReturnCode(json.getInteger("return_code"));
        response.setReturnMessage(json.getString("return_message"));
        response.setData(json.getString("data"));
        bufferedReader.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      if(connection != null)
      connection.disconnect();
    }
    System.out.println(response);
    return response;
  }

  public static String getTime(Date date){
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    String time = date.getTime()+"";
    return time.substring(0,10);
  }

  public static String setKey(String appkey,String secretKey){
    return appkey+":"+secretKey.trim();
  }

}
