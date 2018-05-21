package com.s63d.ertripconsumer.config

import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component


@Component
class QueueBinding {
    @Bean
    fun queue() = Queue("proftaak", true)

    @Bean
    fun exchange(): DirectExchange = DirectExchange("locations")

    @Bean
    fun binding(queue: Queue, exchange: DirectExchange) = BindingBuilder.bind(queue).to(exchange).with("abc.a")

    @Bean
    fun jsonMessageConverter(): MessageConverter = Jackson2JsonMessageConverter()
}