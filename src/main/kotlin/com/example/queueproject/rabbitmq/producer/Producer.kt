package com.example.queueproject.rabbitmq.producer

import com.example.queueproject.rabbitmq.model.RequestModel
import com.example.queueproject.rabbitmq.service.RabbitMQService
import org.springframework.web.bind.annotation.*

@RestController
class Producer(
    private val rabbitMQService: RabbitMQService
) {

    @PostMapping("/send")
    fun sendMessage(@RequestBody requestModel: RequestModel){
        rabbitMQService.send(requestModel)
    }
}