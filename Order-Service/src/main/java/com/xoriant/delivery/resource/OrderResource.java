package com.xoriant.delivery.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.delivery.model.Order;
import com.xoriant.delivery.msgsender.MessageSender;
import com.xoriant.delivery.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderResource {

	@Autowired
	OrderService orderService;

	@Autowired
	private MessageSender messageSender;

	@GetMapping("/save")
	public Order addNewOrder(@RequestParam String productName, @RequestParam int quantity) {
		Order orderPlaced = orderService.addNewOrder(productName, quantity);
		String result = "PRODUCT NAME :: " + orderPlaced.getProductName() + " " + "Total Amount :: "
				+ orderPlaced.getTotalAmount();
		if (result != null) {
			messageSender.addNewOrderDetails(result);
		}
		return orderPlaced;
	}
}
