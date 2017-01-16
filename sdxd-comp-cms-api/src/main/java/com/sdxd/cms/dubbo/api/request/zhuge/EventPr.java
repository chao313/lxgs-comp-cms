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
public class EventPr implements Serializable {

  private String pr;

}
