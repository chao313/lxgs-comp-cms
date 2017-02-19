package com.sdxd.cms.service;

import com.sdxd.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.common.mq.pojo.approve.ApproveDone;

public interface ApproveDoneEventService {

	ZhugeResponse pushZhuGe(ApproveDone approveDone);
}
