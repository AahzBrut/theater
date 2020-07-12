package com.aahzbrut.theater.dto

data class BookingRequest(
        val seatId: Long = 0,
        val performanceId: Long = 0,
        val customerName: String = ""
)