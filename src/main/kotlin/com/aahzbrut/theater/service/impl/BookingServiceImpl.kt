package com.aahzbrut.theater.service.impl

import com.aahzbrut.theater.domain.Seat
import com.aahzbrut.theater.service.BookingService
import org.springframework.stereotype.Service

@Service
class BookingServiceImpl : BookingService {

    override fun isSeatFree(seat: Seat): Boolean = true
}