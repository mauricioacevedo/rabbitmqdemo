package com.rabbitmq.rabbitdemo.listener;

import com.rabbitmq.rabbitdemo.sendMessage.BasicMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class RabbitMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("new String(message.getBody()) = " + new String(message.getBody(), Charset.defaultCharset().name()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
