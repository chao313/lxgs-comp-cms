package com.sdxd.cms.dubbo.api.request.zhuge;

import com.sdxd.framework.dubbo.BaseRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by yaojun on 2017/1/14.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class ZhugeDataRequest extends BaseRequest{

  private PersonRequest personRequest;
  private EventRequest eventRequest;
  private String data;
}
