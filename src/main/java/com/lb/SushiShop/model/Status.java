package com.lb.SushiShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATUS")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "NAME")
	String name;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Status [id=" + id + ", name=" + name + "]";
	}
}
