package com.aahzbrut.theater.service

import com.aahzbrut.theater.dto.BookingRequest
import com.aahzbrut.theater.dto.BookingResponse
import com.aahzbrut.theater.dto.PerformanceResponse
import com.aahzbrut.theater.dto.SeatResponse

interface BookingService {
    fun isSeatFree(seat: SeatResponse, performance: PerformanceResponse?): Boolean
    fun addBooking(bookingRequest: BookingRequest): Long
    fun findBooking(seat: SeatResponse, performance: PerformanceResponse): BookingResponse?
    fun getBooking(bookingId: Long):BookingResponse
}