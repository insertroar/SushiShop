package com.lb.SushiShop.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderSummary {
	
	List<OrderTimeSpent> in_progress;
	List<OrderTimeSpent> created;
	List<OrderTimeSpent> paused;
	List<OrderTimeSpent> cancelled;
	List<OrderTimeSpent> completed;
	
	public OrderSummary() {

		this.in_progress = new ArrayList<>();
		this.created = new ArrayList<>();
		this.paused = new ArrayList<>();
		this.cancelled = new ArrayList<>();
		this.completed = new ArrayList<>();
		
	}

	public List<OrderTimeSpent> getIn_progress() {
		return in_progress;
	}

	public List<OrderTimeSpent> getCreated() {
		return created;
	}

	public void setCreated(List<OrderTimeSpent> created) {
		this.created = created;
	}

	public List<OrderTimeSpent> getPaused() {
		return paused;
	}

	public void setPaused(List<OrderTimeSpent> paused) {
		this.paused = paused;
	}

	public List<OrderTimeSpent> getCancelled() {
		return cancelled;
	}

	public void setCancelled(List<OrderTimeSpent> cancelled) {
		this.cancelled = cancelled;
	}

	public List<OrderTimeSpent> getCompleted() {
		return completed;
	}

	public void setCompleted(List<OrderTimeSpent> completed) {
		this.completed = completed;
	}

	public void setIn_progress(List<OrderTimeSpent> in_progress) {
		this.in_progress = in_progress;
	}
	
}

