package com.simple.web;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {
	
	private final RabbitTemplate rabbitTemplate;
	
	public SenderController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@RequestMapping("send")
	public void send() {
		rabbitTemplate.convertAndSend(
				SimpleRabbitAppOneApplication.topicExchangeName,
				"foo.bar.baz",
				"Hello from SenderController"
		);
	}
}
