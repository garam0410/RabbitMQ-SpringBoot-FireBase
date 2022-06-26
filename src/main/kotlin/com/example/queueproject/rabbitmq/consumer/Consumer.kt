package com.example.queueproject.rabbitmq.consumer

import com.example.queueproject.config.QUEUE
import com.example.queueproject.rabbitmq.model.RequestModel
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import java.util.*

@Component
class Consumer {

    @RabbitListener(queues = [QUEUE])
    fun getMessage(model: RequestModel) {
        val status = Random().nextBoolean()
        println(status)
        if (status) {
            println("성공 : ${model.message}\n")
        } else {
            throw Exception("에러")
        }
    }
}