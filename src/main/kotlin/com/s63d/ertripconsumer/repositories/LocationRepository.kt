package com.s63d.ertripconsumer.repositories

import com.s63d.ertripconsumer.domain.Location
import org.springframework.data.repository.CrudRepository

interface LocationRepository : CrudRepository<Location, Long>