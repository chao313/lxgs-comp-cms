package com.sdxd.cms.dubbo.api.request.zhuge;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by yaojun on 2017/1/14.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class ZhugeEventRequest extends ZhugeBaseRequest<EventPer> {
//实时调试: 1为实时调试, 0或缺少此字段为正式数据
  private int debug;
  private ZhugeEventData<EventPer>[] data;

}
