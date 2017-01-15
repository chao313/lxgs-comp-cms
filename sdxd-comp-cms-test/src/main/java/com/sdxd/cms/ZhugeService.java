package com.sdxd.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sdxd.cms.dubbo.api.ZhugeIODubboService;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeDataRequest;
import com.sdxd.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.framework.dubbo.DubboResponse;

import org.springframework.stereotype.Service;

/**
 * Created by yaojun on 2017/1/15.
 */
@Service
public class ZhugeService {

  @Reference(version = "1.0.0")
  private ZhugeIODubboService service;

  public DubboResponse<ZhugeResponse> RecordParams(ZhugeDataRequest request){
    return service.RecordParams(request);
  }

}
