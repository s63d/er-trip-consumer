package com.s63d.ertripconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ErTripConsumerApplication

fun main(args: Array<String>) {
    runApplication<ErTripServiceApplication>(*args)
}