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
public class PersonRequest extends ZhugeBaseRequest<PersonPer> {

  private ZhugePersonData<PersonPer>[] data;

}