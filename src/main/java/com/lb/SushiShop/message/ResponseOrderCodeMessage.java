package com.lb.SushiShop.message;

import com.lb.SushiShop.model.Sushi_order;

public class ResponseOrderCodeMessage extends ResponseCodeMessage {

	Sushi_order order;
	
	public ResponseOrderCodeMessage(Sushi_order order, int code, String msg) {
		super(code, msg);
		
		this.order = order;
	}

	public Sushi_order getOrder() {
		return order;
	}

	public void setOrder(Sushi_order order) {
		this.order = order;
	}
	
}
