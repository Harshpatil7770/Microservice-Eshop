package com.xoriant.delivery.resource;

import java.util.logging.Logger;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

@Controller
public class MessageResource {

	private Logger logger = Logger.getLogger(MessageResource.class.getName());

	@RabbitListener(queues = "orderQ")
	public void newOrderPlaced(String msg) {
		logger.info("newOrderPlaced () called");
		System.out.println(msg);
	}
}
