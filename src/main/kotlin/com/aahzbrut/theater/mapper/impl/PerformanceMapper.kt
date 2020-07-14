package com.aahzbrut.theater.mapper.impl

import com.aahzbrut.theater.domain.Performance
import com.aahzbrut.theater.dto.PerformanceAddRequest
import com.aahzbrut.theater.mapper.Mapper
import org.springframework.stereotype.Service

@Service
class PerformanceMapper : Mapper<Performance, PerformanceAddRequest> {

    override fun from(source: PerformanceAddRequest): Performance {
        val performance = Performance(0)
        performance.title = source.title!!
        return performance
    }
}