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
public class PersonPer {

  @NotNull(message = "手机号码不能为空")
  private String mobile;
  @NotNull(message = "姓名不能为空")
  private String name;

}
