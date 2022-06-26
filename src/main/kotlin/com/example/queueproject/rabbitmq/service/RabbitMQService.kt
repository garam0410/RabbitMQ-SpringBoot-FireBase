package com.example.queueproject.rabbitmq.service

import com.example.queueproject.config.EXCHANGE
import com.example.queueproject.config.ROUTING_KEY
import com.example.queueproject.rabbitmq.model.RequestModel
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class RabbitMQService(
    private val rabbitTemplate: RabbitTemplate
) {
    fun send(requestModel: RequestModel): String {
        for (i in 1..10){
            requestModel.plus(1)
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, requestModel)
        }
        return "Success !!"
    }
}