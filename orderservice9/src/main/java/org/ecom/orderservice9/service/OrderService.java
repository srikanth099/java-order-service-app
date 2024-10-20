package org.ecom.orderservice9.service;

import java.util.Date;

import org.ecom.orderservice9.dto.OrderDto;
import org.ecom.orderservice9.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemplate;

	public String placeOrder(OrderDto orderDto) {
		OrderEntity entity = new OrderEntity();
		entity.setProductId(orderDto.getProductId());
		entity.setPaymentMode(orderDto.getPaymentMode());
		entity.setQuantity(orderDto.getQuantity());
		entity.setSoldDate(new Date());
		entity.setTotalPrice(0);

		StringBuilder urlbuilder = new StringBuilder();
		urlbuilder.append("http://localhost:8080/productservice9/findProductPriceByProductId");
		urlbuilder.append(orderDto.getProductId());

		Double productPrice = restTemplate.getForObject(urlbuilder.toString(), Double.class);
		System.out.println("productPrice :" + productPrice);
		entity.setTotalPrice((productPrice * orderDto.getQuantity()));

		return "Order Placed Successfully";
	}

}
