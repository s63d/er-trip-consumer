package com.s63d.ertripconsumer.listeners

import com.s63d.ertripconsumer.domain.Location
import com.s63d.ertripconsumer.repositories.LocationRepository
import org.springframework.amqp.rabbit.annotation.Exchange
import org.springframework.amqp.rabbit.annotation.Queue
import org.springframework.amqp.rabbit.annotation.QueueBinding
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class LocationListener(private val locationRepository: LocationRepository) {

    data class LocationMessage(val tripId: Long, val lat: Double, val lon: Double) {
        private constructor() : this(0,0.0,0.0)
    }

    @RabbitListener(bindings = [(QueueBinding(value = Queue("INTERN_AT_LOCATION"), key = ["location"], exchange = Exchange("AT")))])
    fun onLocationMessage(message: LocationMessage) {
        locationRepository.save(Location(message.lat, message.lon, message.tripId))
    }

}