package com.aahzbrut.theater.dto

data class BookingResponse (
    val id: Long?,
    val performance: PerformanceResponse?,
    val seat: SeatResponse?,
    val customerName: String?
)