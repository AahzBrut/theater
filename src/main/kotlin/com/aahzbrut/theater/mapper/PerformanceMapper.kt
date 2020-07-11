package com.aahzbrut.theater.mapper

import com.aahzbrut.theater.domain.Performance
import com.aahzbrut.theater.dto.PerformanceAddRequest
import org.springframework.stereotype.Service

@Service
class PerformanceMapper : Mapper<Performance, PerformanceAddRequest> {

    override fun from(source: PerformanceAddRequest): Performance =
            Performance(0, emptyList(), source.title)
}