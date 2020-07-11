package com.aahzbrut.theater.service

import com.aahzbrut.theater.dto.PerformanceAddRequest
import com.aahzbrut.theater.dto.PerformanceResponse

interface PerformanceService {

    fun getAll(): List<PerformanceResponse>
    fun getOne(id: Long): PerformanceResponse
    fun save(request: PerformanceAddRequest)
}