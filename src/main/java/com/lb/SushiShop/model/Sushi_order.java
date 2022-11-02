package com.lb.SushiShop.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUSHI_ORDER")
public class Sushi_order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "STATUS_ID")
	int status_id;
	
	@Column(name = "SUSHI_ID")
	int sushi_id;
	
	@Column(name="CREATEDAT")
	Timestamp createdAt;
	
	public Sushi_order() {
	}

	public Sushi_order(int status_id, int sushi_id) {

		this.status_id = status_id;
		this.sushi_id = sushi_id;
		
		this.createdAt = new Timestamp(System.currentTimeMillis());
	}

	public int getId() {
		return id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getSushi_id() {
		return sushi_id;
	}

	public void setSushi_id(int sushi_id) {
		this.sushi_id = sushi_id;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "Sushi_order [id=" + id + ", status_id=" + status_id + ", sushi_id=\" + sushi_id + \", createdAt=" + createdAt + "]";
	}	
}
