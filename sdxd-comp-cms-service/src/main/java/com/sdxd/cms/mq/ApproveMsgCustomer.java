package com.sdxd.cms.mq;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.sdxd.cms.service.ApproveDoneEventService;
import com.sdxd.common.mq.pojo.approve.ApproveDone;
import com.sdxd.common.mq.util.Serialization;

public class ApproveMsgCustomer implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApproveMsgCustomer.class);
	@Resource
	private ApproveDoneEventService approveDoneEventService;

	@Override
	public Action consume(Message message, ConsumeContext context) {
		LOGGER.debug(",key:{}", message.getKey());
		ApproveDone approveDone = Serialization.getPOJO(message.getBody(), ApproveDone.class);
		try {
			approveDoneEventService.pushApproveDoneZhuge(approveDone);
		} catch (Exception e) {
			LOGGER.error("消息消费失败", e);
		}
		return Action.CommitMessage;

	}

}
