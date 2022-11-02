package com.lb.SushiShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lb.SushiShop.bean.OrderSummary;
import com.lb.SushiShop.message.ResponseCodeMessage;
import com.lb.SushiShop.message.ResponseOrderCodeMessage;
import com.lb.SushiShop.model.Sushi;
import com.lb.SushiShop.model.Sushi_order;
import com.lb.SushiShop.service.SushiShopService;

@RestController
public class RESTController {
	
	@Autowired
    SushiShopService sushiShopService;
	
    @GetMapping("/api/sushis")
    private List getAllSushis() {
        return sushiShopService.getAllSushis();
    }
    
    @PostMapping("/api/orders")
    private ResponseOrderCodeMessage createOrder(@RequestBody Sushi sushi) {
    	Sushi_order sushi_order = null;
    	
        try {
        	int sushiId = sushiShopService.getSushiIdByName(sushi.getSushi_name());
        	if(sushiShopService.getNumberOfOrdersInProgress() > 2) {
            	sushi_order = new Sushi_order(1, sushiId);
        	}else {
            	sushi_order = new Sushi_order(2, sushiId);
        	}
        	
        	sushiShopService.saveOrUpdateOrder(sushi_order);
        } catch (Exception exception) {
            //return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        	return new ResponseOrderCodeMessage(null, 500, ResponseCodeMessage.ORDER_CREATE_ERROR);
        }
        
        //return new ResponseCodeMessage("New order created with sushi_name: " + sushi.getSushi_name(), HttpStatus.CREATED);
        return new ResponseOrderCodeMessage(sushi_order, 0, ResponseCodeMessage.ORDER_CREATE_SUCCESS);
    }
	
    @DeleteMapping("/api/orders/{order_id}")
    private ResponseCodeMessage cancellOrderById(@PathVariable("order_id") int id) {
        try {
        	sushiShopService.cancellOrder(id);
        } catch (Exception exception) {
            //return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        	return new ResponseCodeMessage(500, ResponseCodeMessage.ORDER_CANCEL_ERROR);
        }
        //return new ResponseEntity("Order cancelled successfully! id: " + id, HttpStatus.OK);
        return new ResponseCodeMessage(0, ResponseCodeMessage.ORDER_CANCEL_SUCCESS);
    }
    
    @GetMapping("/api/orders/status")
    private OrderSummary getOrdersByStatus() {
    	
    	return sushiShopService.displayOrdersByStatus();
    }
    
    @PutMapping("/api/orders/{order_id}/finished")
    private ResponseCodeMessage finishOrderById(@PathVariable("order_id") int id) {
        try {
        	sushiShopService.finishedOrder(id);
        	sushiShopService.addCreatedSushiOrder();
        } catch (Exception exception) {
            //return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        	return new ResponseCodeMessage(500, ResponseCodeMessage.ORDER_FINISHED_ERROR);
        }
        //return new ResponseEntity("Order finished successfully! id: " + id, HttpStatus.OK);
        return new ResponseCodeMessage(0, ResponseCodeMessage.ORDER_FINISHED_SUCCESS);
    }
    
    @PutMapping("/api/orders/{order_id}/pause")
    private ResponseCodeMessage pauseOrderById(@PathVariable("order_id") int id) {
        try {
        	sushiShopService.pauseOrder(id);
        } catch (Exception exception) {
            //return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        	return new ResponseCodeMessage(500, ResponseCodeMessage.ORDER_PAUSE_ERROR);
        }
        //return new ResponseEntity("Order paused successfully! id: " + id, HttpStatus.OK);
        return new ResponseCodeMessage(0, ResponseCodeMessage.ORDER_PAUSE_SUCCESS);
    }
    
    @PutMapping("/api/orders/{order_id}/resume")
    private ResponseCodeMessage resumeOrderById(@PathVariable("order_id") int id) {
        try {
        	sushiShopService.resumeOrder(id);
        } catch (Exception exception) {
            //return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        	return new ResponseCodeMessage(500, ResponseCodeMessage.ORDER_RESUME_ERROR);
        }
        //return new ResponseEntity("Order resumed successfully! id: " + id, HttpStatus.OK);
        return new ResponseCodeMessage(0, ResponseCodeMessage.ORDER_RESUME_SUCCESS);
    }
    
}
