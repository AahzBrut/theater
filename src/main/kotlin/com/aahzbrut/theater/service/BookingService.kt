package com.aahzbrut.theater.service

import com.aahzbrut.theater.dto.PerformanceResponse
import com.aahzbrut.theater.dto.SeatResponse

interface BookingService {
    fun isSeatFree(seat: SeatResponse, performance: PerformanceResponse?): Boolean
}