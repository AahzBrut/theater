package com.aahzbrut.theater.service

import com.aahzbrut.theater.domain.Seat

interface BookingService {
    fun isSeatFree(seat: Seat): Boolean
}