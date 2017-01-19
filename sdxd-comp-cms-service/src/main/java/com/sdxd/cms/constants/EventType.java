package com.sdxd.cms.constants;

public enum EventType {

	APPROVE_ENT_PASS(11,"信审通过")
	,APPROVE_ENT_REF(12,"信审拒绝")
	
	
	,LOAN_COMPLETED(21,"放款成功")
	,LOAN_REJECTED(22,"放款拒绝")
	,LOAN_FAILURE(23,"放款失败")
	;
	
	private int value;
	private String desc;
	
	private EventType(int value,String desc){
		this.desc = desc;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
