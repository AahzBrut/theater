package com.aahzbrut.theater.service

import com.aahzbrut.theater.dto.BookingRequest
import com.aahzbrut.theater.dto.BookingResponse
import com.aahzbrut.theater.dto.PerformanceResponse
import com.aahzbrut.theater.dto.SeatResponse

interface BookingService {
    fun isSeatFree(seat: SeatResponse, performance: PerformanceResponse?): Boolean
    fun reserveSeat(bookingRequest: BookingRequest): Any
    fun findBooking(seat: SeatResponse, performance: PerformanceResponse): BookingResponse?
}