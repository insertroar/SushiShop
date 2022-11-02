package com.lb.SushiShop.bean;

public class OrderTimeSpent {
	
	int orderId;
	long timeSpent;
	
	public OrderTimeSpent(int orderId, long timeSpent) {
		this.orderId = orderId;
		this.timeSpent = timeSpent;
	}

	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public long getTimeSpent() {
		return timeSpent;
	}
	
	public void setTimeSpent(long timeSpent) {
		this.timeSpent = timeSpent;
	}	
	
}
