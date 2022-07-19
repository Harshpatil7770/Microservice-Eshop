package com.xoriant.delivery.msgsender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Bean
	public Queue addNewOrder() {
		return new Queue("orderQ", false);
	}

	public void addNewOrderDetails(String msg) {
		rabbitTemplate.convertAndSend("orderQ", msg);
	}

}
