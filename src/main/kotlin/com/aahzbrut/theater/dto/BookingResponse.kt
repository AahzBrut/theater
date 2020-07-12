package com.aahzbrut.theater.dto

data class BookingResponse (
    var id: Long,
    var performance: PerformanceResponse,
    var seat: SeatResponse,
    var customerName: String
)