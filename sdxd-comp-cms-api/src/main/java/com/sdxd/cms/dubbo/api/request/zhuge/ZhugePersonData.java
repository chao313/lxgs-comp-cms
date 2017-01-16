package com.sdxd.cms.dubbo.api.request.zhuge;

import java.io.Serializable;

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
public class ZhugePersonData<T> implements Serializable {

  private PersonPr pr;
@NotNull(message = "用户信息不可为空")
  private String et =  "idf";
  @NotNull(message = "事件时间不可为空")
  private String ts;
  @NotNull(message = "用户id不能为空")
  private String cuid;
}
