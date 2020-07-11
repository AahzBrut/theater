package com.aahzbrut.theater.dto

import com.aahzbrut.theater.domain.Performance
import com.aahzbrut.theater.domain.Seat

data class BookingResponse (
        val id: Long,
        val performance: Performance,
        val seat: Seat,
        val customerName: String
)