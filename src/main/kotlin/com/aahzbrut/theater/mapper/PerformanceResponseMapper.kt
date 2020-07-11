package com.aahzbrut.theater.mapper

import com.aahzbrut.theater.domain.Performance
import com.aahzbrut.theater.dto.PerformanceResponse
import org.springframework.stereotype.Service

@Service
class PerformanceResponseMapper : Mapper<PerformanceResponse, Performance> {

    override fun from(source: Performance): PerformanceResponse =
            PerformanceResponse(source.id, source.title)
}