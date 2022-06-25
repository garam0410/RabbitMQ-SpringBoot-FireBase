package com.example.queueproject.rabbitmq.consumer

import com.example.queueproject.config.QUEUE
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class Consumer {

    @RabbitListener(queues = [QUEUE])
    fun getMessage(message: String){
        println("받은 메시지 : $message")
    }
}