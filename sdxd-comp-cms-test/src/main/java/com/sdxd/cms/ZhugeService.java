package com.sdxd.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sdxd.cms.dubbo.api.ZhugeIODubboService;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventRequest;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugePersonRequest;
import com.sdxd.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.framework.dubbo.DubboResponse;

import org.springframework.stereotype.Service;

/**
 * Created by yaojun on 2017/1/15.
 */
@Service
public class ZhugeService {

  @Reference(version = "1.0.0")
  private ZhugeIODubboService zhugeIODubboService;

  public DubboResponse<ZhugeResponse> RecordParams(ZhugeEventRequest request){
    return zhugeIODubboService.RecordParams(request);
  }
  public DubboResponse<ZhugeResponse> RecordParams(ZhugePersonRequest request){
    return zhugeIODubboService.RecordParams(request);
  }

}
