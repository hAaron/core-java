package com.aaron.util.rocketmq.quickstart;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.Charset;

/** */
public class RocketMQProcuder {

  public static void main(String[] args) {
      //需要一个producer group名字作为构造方法的参数，这里为producer1
      DefaultMQProducer producer = new DefaultMQProducer("mqTest");

      //设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用；分隔
      //NameServer的地址必须有，但是也可以通过环境变量的方式设置，不一定非得写死在代码里
      //producer.setNamesrvAddr("3.0.181.3:8276");
      producer.setNamesrvAddr(RocketMQConfig.NAME_ADDR);
      producer.setVipChannelEnabled(false);

      //为避免程序启动的时候报错，添加此代码，可以让rocketMq自动创建topickey
      producer.setCreateTopicKey(RocketMQConfig.MQ_TOPIC);
      try {
          producer.start();
          for(int i=0;i<10;i++){
              try {
                  Message message = new Message(RocketMQConfig.MQ_TOPIC, "Tag1",
                          ("Hello RocketMQ " + i).getBytes(Charset.defaultCharset()));

                  SendResult sendResult = producer.send(message);

                  System.out.println("发送的消息ID:" + sendResult.getMsgId() +"--- 发送消息的状态：" + sendResult.getSendStatus());
              } catch (Exception e) {
                  e.printStackTrace();
                  Thread.sleep(1000);
              }
          }
      } catch (MQClientException | InterruptedException e) {
          e.printStackTrace();
      }

      producer.shutdown();
    }
}