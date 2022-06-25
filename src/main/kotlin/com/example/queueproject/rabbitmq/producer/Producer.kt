package com.example.queueproject.rabbitmq.producer

import com.example.queueproject.rabbitmq.service.RabbitMQService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Producer(
    private val rabbitMQService: RabbitMQService
) {

    @GetMapping("/send")
    fun sendMessage(@RequestParam message: String){
        rabbitMQService.send(message)
    }
}