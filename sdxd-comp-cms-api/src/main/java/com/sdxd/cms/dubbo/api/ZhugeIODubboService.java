package com.sdxd.cms.dubbo.api;


import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugePersonRequest;
import com.sdxd.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.framework.dubbo.DubboResponse;

/**
 * Created by yaojun on 2017/1/14.
 */
public interface ZhugeIODubboService {

  public DubboResponse<ZhugeResponse> RecordEventParams(ZhugeEventRequest request);
  public DubboResponse<ZhugeResponse> RecordPerParams(ZhugePersonRequest request);

}
