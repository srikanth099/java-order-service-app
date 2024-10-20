package org.ecom.orderservice9.controller;

import org.ecom.orderservice9.dto.OrderDto;
import org.ecom.orderservice9.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value="/placeorder")
	public String placeOrder(OrderDto orderDto) {
		return orderService.placeOrder(orderDto);
		
	}

}
