package com.sdxd.cms.mq;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.sdxd.cms.constants.EventType;
import com.sdxd.cms.service.ApproveDoneEventService;
import com.sdxd.common.mq.pojo.loan.LoanDone;
import com.sdxd.common.mq.pojo.loan.LoanRejected;
import com.sdxd.common.mq.util.Serialization;

public class LoanMsgCustomer implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoanMsgCustomer.class);
	@Resource
	private ApproveDoneEventService approveDoneEventService;

	@Override
	public Action consume(Message message, ConsumeContext context) {
		LOGGER.info("消费放款结果,key:{}", message.getKey());
		switch (message.getTag()) {
		case "TAG_LOAN_COMPLETED":
			LoanDone loanDone = Serialization.getPOJO(message.getBody(), LoanDone.class);
			LOGGER.info("放款成功消息内容,msgId={}, data={}", message.getMsgID(), JSONObject.toJSONString(loanDone));
			if(loanDone!=null){
				approveDoneEventService.pushLoanZhuge(loanDone.getUserId(),loanDone.getLoanTime(),EventType.LOAN_COMPLETED);
			}
			break;
		case "TAG_LOAN_REJECTED":
			LoanRejected loanR = Serialization.getPOJO(message.getBody(), LoanRejected.class);
			LOGGER.info("放款拒绝消息内容,msgId={}, data={}", message.getMsgID(), JSONObject.toJSONString(loanR));
			if(loanR!=null){
//				approveDoneEventService.pushLoanZhuge(loanR.getUserId(),new Date(),EventType.LOAN_COMPLETED);
			}
			break;
		case "TAG_LOAN_FAILURE":
			LoanDone loanF = Serialization.getPOJO(message.getBody(), LoanDone.class);
			LOGGER.info("放款失败消息内容,msgId={}, data={}", message.getMsgID(), JSONObject.toJSONString(loanF));
			if(loanF!=null){
				approveDoneEventService.pushLoanZhuge(loanF.getUserId(),loanF.getLoanTime(),EventType.LOAN_FAILURE);
			}
			break;
		default:
			LOGGER.error("不匹配的tag，{}", message.getTag());
			break;
		}
		return Action.CommitMessage;

	}
}
