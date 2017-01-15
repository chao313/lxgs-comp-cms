package com.sdxd.cms.dubbo.api.request.zhuge;

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
public class ZhugeEventData<T> {

  private EventPer per;
  @NotNull(message = "自定义事件不可为空")
  private String et = "cus";
  @NotNull(message = "事件时间不可为空")
  private String ts;
  @NotNull(message = "事件名称不可为空")
  private String  eid;
}
