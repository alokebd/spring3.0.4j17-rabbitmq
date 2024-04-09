package com.vision.rabbitmq.cosumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.vision.rabbitmq.config.RabbitMQConfig;
import com.vision.rabbitmq.entity.OrderDTO;

@Component
public class RabbitMQConsumer {
	
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consume(OrderDTO orderDTO){
        System.out.println("consumer is able to consume messgae form queues"+orderDTO);
    }
}
