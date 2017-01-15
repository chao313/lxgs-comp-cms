package com.sdxd.cms.dubbo.api;

import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeDataRequest;
import com.sdxd.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.framework.dubbo.DubboResponse;

/**
 * Created by yaojun on 2017/1/14.
 */
public interface ZhugeIODubboService {

  public DubboResponse<ZhugeResponse> RecordParams(ZhugeDataRequest request);

}
