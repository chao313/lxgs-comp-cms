package com.lxgs.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lxgs.cms.dubbo.api.ZhugeIODubboService;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugeEventRequest;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugePersonRequest;
import com.lxgs.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.framework.dubbo.DubboResponse;

import org.springframework.stereotype.Service;

/**
 * Created by yaojun on 2017/1/15.
 */
@Service
public class ZhugeService {

  @Reference(version = "1.0.0")
  private ZhugeIODubboService zhugeIODubboService;

  public DubboResponse<ZhugeResponse> RecordEventParams(ZhugeEventRequest request){
    return zhugeIODubboService.RecordEventParams(request);
  }
  public DubboResponse<ZhugeResponse> RecordPerParams(ZhugePersonRequest request){
    return zhugeIODubboService.RecordPerParams(request);
  }

}
