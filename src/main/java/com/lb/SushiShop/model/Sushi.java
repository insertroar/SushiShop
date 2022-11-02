package com.lb.SushiShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUSHI")
public class Sushi {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "NAME")
	String sushi_name;
	
	@Column(name = "TIME_TO_MAKE")
	int time_to_make;
	
	public int getId() {
		return id;
	}
		
	public String getSushi_name() {
		return sushi_name;
	}

	public void setSushi_name(String sushi_name) {
		this.sushi_name = sushi_name;
	}

	public int getTime_to_make() {
		return time_to_make;
	}
	
	public void setTime_to_make(int time_to_make) {
		this.time_to_make = time_to_make;
	}
	
	@Override
	public String toString() {
		return "Sushi [id=" + id + ", sushi_name=" + sushi_name + ", time_to_make=" + time_to_make + "]";
	}
}
