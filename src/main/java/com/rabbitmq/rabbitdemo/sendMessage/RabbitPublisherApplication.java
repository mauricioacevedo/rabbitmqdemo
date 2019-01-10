package com.rabbitmq.rabbitdemo.sendMessage;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class RabbitPublisherApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitPublisherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		BasicMessage basicMessage = new BasicMessage();
		basicMessage.setName("Message to Fabri");
		basicMessage.setDesc("Description of the message sent by Fuli");

		//posting binary class message
		rabbitTemplate.convertAndSend("myTopicExchangeJava", "topic", basicMessage);
	}
}

