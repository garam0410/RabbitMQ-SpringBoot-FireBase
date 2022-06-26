package com.example.queueproject.rabbitmq.model

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.*

@Getter
@Setter
@Builder
data class RequestModel(
    @JsonProperty("message")
    var message: Long
) {
    fun plus(num: Int){
        message += num
    }
}