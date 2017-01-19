package com.sdxd.cms.constants;

/**
 * Created by yaojun on 2017/1/19.
 */
public enum ZhuGeVar {



  ZHUGE_API_URL("ZHUGE_API_URL")
  ,ZHUGE_API_APPKEY("ZHUGE_API_APPKEY")
  ,ZHUGE_API_SECRETKEY("ZHUGE_API_SECRETKEY")
  ;
  private String code;
  private ZhuGeVar(String code){
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
