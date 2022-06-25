package com.example.queueproject.config

import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

const val QUEUE: String = "example_queue"
const val EXCHANGE: String = "example_exchange"
const val ROUTING_KEY: String = "example_routingKey"

@Configuration
class RabbitMQConfiguration(
) {
    @Bean
    fun queue(): Queue? {
        return Queue(QUEUE)
    }

    @Bean
    fun exchange(): TopicExchange? {
        return TopicExchange(EXCHANGE)
    }

    @Bean
    fun binding(queue: Queue?, exchange: TopicExchange?): Binding? {
        return BindingBuilder.bind(queue).to(exchange)
            .with(ROUTING_KEY)
    }

    @Bean
    fun converter(): MessageConverter? {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun template(connectionFactory: ConnectionFactory?): AmqpTemplate? {
        val rabbitTemplate = RabbitTemplate(connectionFactory!!)
        rabbitTemplate.messageConverter = converter()!!
        return rabbitTemplate
    }
}