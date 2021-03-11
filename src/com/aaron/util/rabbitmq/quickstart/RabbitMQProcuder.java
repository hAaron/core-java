package com.aaron.util.rabbitmq.quickstart;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/** */
public class RabbitMQProcuder {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(RabbitMQConfig.HOST_NAME);
        connectionFactory.setPort(RabbitMQConfig.PORT);
        connectionFactory.setUsername(RabbitMQConfig.USER);
        connectionFactory.setPassword(RabbitMQConfig.PWD);
        connectionFactory.setVirtualHost(RabbitMQConfig.VIRTUAL_HOST);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        // for (int i = 0; i < 5; i++) {
        // String msg = "Hello RabbitMQ!";
        // channel.basicPublish("", RabbitMQConfig.QUEUE_NAME, null, msg.getBytes());
        // }

        while (true) {
            Thread.sleep(2);
            String msg = "Hello RabbitMQ!";
            channel.basicPublish("", RabbitMQConfig.QUEUE_NAME, null, msg.getBytes());
        }

        // channel.close();
        // connection.close();
    }
}
