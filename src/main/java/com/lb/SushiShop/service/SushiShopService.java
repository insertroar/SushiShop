package com.lb.SushiShop.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.SushiShop.bean.OrderSummary;
import com.lb.SushiShop.bean.OrderTimeSpent;
import com.lb.SushiShop.constant.Constants;
import com.lb.SushiShop.model.Sushi;
import com.lb.SushiShop.model.Sushi_order;
import com.lb.SushiShop.repository.OrderRepository;
import com.lb.SushiShop.repository.SushiRepository;

@Service
public class SushiShopService {

	@Autowired
	SushiRepository sushiRepository;
	@Autowired
	OrderRepository orderRepository;
	
	public List<Sushi> getAllSushis() {
		List<Sushi> sushis = new ArrayList<>();
		
		sushiRepository.findAll().forEach(sushi -> sushis.add(sushi));
		
		return sushis;
	}
	
	public Sushi getSushiById (int id) {
		return sushiRepository.findById(id).get();
	}
	
	public int getSushiIdByName (String name) {
		List<Sushi> sushis = sushiRepository.findAll();
		
		int id = 0;
		for(Sushi s : sushis) {
			if(name.equals(s.getSushi_name())) {
				id = s.getId();
			}
		}
		
		return id;
	}
	
	public void saveOrUpdateOrder(Sushi_order order) {
		try {
			orderRepository.save(order);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	public void cancellOrder(int orderId) {
		Sushi_order order = orderRepository.findById(orderId).get();		
		order.setStatus_id(Constants.ORDER_CANCELLED);
		
		orderRepository.save(order);
	}
	
	public OrderSummary displayOrdersByStatus() {
		
		OrderSummary summary = new OrderSummary();
		
		List<Sushi_order> orders = orderRepository.findAll();
		
		long timeSpent = 0;
		
		for(Sushi_order order : orders) {
			switch (order.getStatus_id()) {
			    case Constants.ORDER_CREATED :
			    	timeSpent = (new Timestamp(System.currentTimeMillis()).getTime() - order.getCreatedAt().getTime())/(1000);
			    	summary.getCreated().add(new OrderTimeSpent(order.getId(),timeSpent));
			    	break;
			    	
			    case  Constants.ORDER_IN_PROGRESS :
			    	timeSpent = (new Timestamp(System.currentTimeMillis()).getTime() - order.getCreatedAt().getTime())/(1000);
			    	summary.getIn_progress().add(new OrderTimeSpent(order.getId(),timeSpent));
			    	break;
			    	
			    case  Constants.ORDER_PAUSED :
			    	timeSpent = (new Timestamp(System.currentTimeMillis()).getTime() - order.getCreatedAt().getTime())/(1000);
			    	summary.getPaused().add(new OrderTimeSpent(order.getId(),timeSpent));
			    	break;
			    	
			    case  Constants.ORDER_FINISHED :
			    	int sushiId = order.getSushi_id();
			    	Sushi sushi = sushiRepository.findById(sushiId).get();

			    	summary.getCompleted().add(new OrderTimeSpent(order.getId(),sushi.getTime_to_make()));
			    	break;
			    	
			    case  Constants.ORDER_CANCELLED :
			    	timeSpent = (new Timestamp(System.currentTimeMillis()).getTime() - order.getCreatedAt().getTime())/(1000);
			    	summary.getCancelled().add(new OrderTimeSpent(order.getId(),timeSpent));
			    	break;
			    	
			    default:
			    	System.out.println("Invalid Input!");
			}			
		}
		
		return summary;
	}
	
	public int getNumberOfOrdersInProgress(){
		List<Sushi_order> orders = orderRepository.findAll();
		int ordersInProgress = 0;
		for(Sushi_order order : orders) {
			if(order.getStatus_id() == Constants.ORDER_IN_PROGRESS) {
				ordersInProgress++;
			}
		}
		return ordersInProgress;
	}
	
	public void addCreatedSushiOrder() {
		List<Sushi_order> orders = orderRepository.findAll();
		for(Sushi_order order : orders) {
			if(order.getStatus_id() == Constants.ORDER_CREATED) {
				order.setStatus_id(Constants.ORDER_IN_PROGRESS);
				orderRepository.save(order);
				break;
			}
		}
	}
	
	public void finishedOrder(int orderId) {
		Sushi_order order = orderRepository.findById(orderId).get();		
		order.setStatus_id(Constants.ORDER_FINISHED);
		
		orderRepository.save(order);
	}
	
	public void pauseOrder(int orderId) {
		Sushi_order order = orderRepository.findById(orderId).get();		
		order.setStatus_id(Constants.ORDER_PAUSED);
		
		orderRepository.save(order);
	}
	
	public void resumeOrder(int orderId) {
		Sushi_order order = orderRepository.findById(orderId).get();		
		order.setStatus_id(Constants.ORDER_IN_PROGRESS);
		
		orderRepository.save(order);
	}
	
}
