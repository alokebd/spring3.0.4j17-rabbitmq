package com.vision.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vision.rabbitmq.config.RabbitMQConfig;
import com.vision.rabbitmq.entity.Order;
import com.vision.rabbitmq.entity.OrderDTO;

@RestController
@RequestMapping("/api")
public class RMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @PostMapping("/order")
    public OrderDTO placeOrder(@RequestBody Order order){

      OrderDTO orderDTO = new OrderDTO(order,"Order Placed" , "Hi Producer Your Order is Placed ");

      rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY , orderDTO);
     return orderDTO;
    }
}
