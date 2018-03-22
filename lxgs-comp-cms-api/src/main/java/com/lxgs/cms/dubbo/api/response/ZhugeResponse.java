package com.lxgs.cms.dubbo.api.response;

import com.sdxd.framework.dubbo.BaseResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by yaojun on 2017/1/13.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class ZhugeResponse extends BaseResponse {

  private Integer returnCode;
  private String returnMessage;
  private String data;
}
