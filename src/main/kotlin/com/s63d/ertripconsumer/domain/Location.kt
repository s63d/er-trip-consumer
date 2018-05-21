package com.s63d.ertripconsumer.domain

import javax.persistence.*

@Entity
data class Location(val lat: Double, val lon: Double, val tripId: Long, @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0)