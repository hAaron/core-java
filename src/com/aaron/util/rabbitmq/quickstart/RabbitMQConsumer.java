package com.aaron.util.rabbitmq.quickstart;

import java.io.IOException;

import com.rabbitmq.client.*;

/** */
public class RabbitMQConsumer {
    public static void main(String[] args) throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(RabbitMQConfig.HOST_NAME);
        connectionFactory.setPort(RabbitMQConfig.PORT);
        connectionFactory.setUsername(RabbitMQConfig.USER);
        connectionFactory.setPassword(RabbitMQConfig.PWD);
        connectionFactory.setVirtualHost(RabbitMQConfig.VIRTUAL_HOST);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(envelope.getExchange() + "," + envelope.getRoutingKey() + "," + message);
            }
        };
        // channel绑定队列，autoAck为true表示一旦收到消息则自动回复确认消息
        channel.basicConsume(RabbitMQConfig.QUEUE_NAME, true, consumer);
    }
}
