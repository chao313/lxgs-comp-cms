package com.sdxd.cms.dubbo.api.request.zhuge;

import com.sdxd.framework.dubbo.BaseRequest;


import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by yaojun on 2017/1/13.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class ZhugeBaseRequest<T> extends BaseRequest{

  @NotNull(message = "上报时间不能为空")
  private String ts;
  @NotNull(message = "用户id不能为空")
  private String cuid;
  @NotNull(message = "AppKey不能为空")
  private String ak = "dfb87d9e3e7a43189959f77789f3fd38";
  @NotNull(message = "平台信息不能为空")
  private String sdk = "web";
//  private T[] data;

}
