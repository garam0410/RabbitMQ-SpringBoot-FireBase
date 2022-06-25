package com.example.queueproject.rabbitmq.service

import com.example.queueproject.config.EXCHANGE
import com.example.queueproject.config.ROUTING_KEY
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service
import org.springframework.util.StopWatch

@Service
class RabbitMQService(
    private val rabbitTemplate: RabbitTemplate
) {
    fun send(message: String): String {
        val time: StopWatch = StopWatch()
        time.start()
        for (i in 1..90000){
            println("전송")
            time.stop()
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, "$message (time : ${time.totalTimeSeconds})")
            time.start()
        }
        time.stop()
        println(time.totalTimeSeconds)
        return "Success !!"
    }
}