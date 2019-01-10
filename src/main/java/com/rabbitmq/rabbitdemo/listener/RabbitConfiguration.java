package com.rabbitmq.rabbitdemo.listener;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    private String myQueue ="myQueueJava";
    private String myExchange="myTopicExchangeJava";

    @Bean
    Queue myQueue() {
        return new Queue(myQueue,true);
    }

    @Bean
    Exchange myExchange() {
        return ExchangeBuilder.topicExchange(myExchange)
                .durable(true)
                .build();
    }

    @Bean
    Binding bindingMyExchangeAndQueue(){
        return BindingBuilder
                .bind(myQueue())
                .to(myExchange())
                .with("topic")
                .noargs();

    }

    //configure connection to RabbitMQ Server
    @Bean
    ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");

        return cachingConnectionFactory;
    }


    @Bean
    MessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer simpleMessageListenerContainer= new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        simpleMessageListenerContainer.setMessageListener(new RabbitMessageListener());

        return simpleMessageListenerContainer;
    }
}
