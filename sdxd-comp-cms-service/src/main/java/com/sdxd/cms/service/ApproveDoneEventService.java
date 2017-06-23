package com.sdxd.cms.service;

import java.util.Date;

import com.sdxd.cms.constants.EventType;
import com.sdxd.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.common.mq.pojo.approve.ApproveDone;

public interface ApproveDoneEventService {

	ZhugeResponse pushApproveDoneZhuge(ApproveDone approveDone);
	
	ZhugeResponse pushLoanZhuge(Long userId,Date eventTime,EventType evenType);
}
