package com.lb.SushiShop.message;

import com.lb.SushiShop.model.Sushi_order;

public class ResponseCodeMessage {

	public static final String ORDER_CREATE_SUCCESS = "Order created";
	public static final String ORDER_CANCEL_SUCCESS = "Order cancelled";
	public static final String ORDER_FINISHED_SUCCESS = "Order finished";
	public static final String ORDER_PAUSE_SUCCESS = "Order paused";
	public static final String ORDER_RESUME_SUCCESS = "Order resumed";

	public static final String ORDER_CREATE_ERROR = "Order create error";
	public static final String ORDER_CANCEL_ERROR = "Order cancelled error";
	public static final String ORDER_FINISHED_ERROR = "Order finished error";
	public static final String ORDER_PAUSE_ERROR = "Order paused";
	public static final String ORDER_RESUME_ERROR = "Order resume error";
	
	int code;
	String msg;
	
	public ResponseCodeMessage(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}	
	
}
