package com.aahzbrut.theater.mapper.impl

import com.aahzbrut.theater.domain.Booking
import com.aahzbrut.theater.domain.Performance
import com.aahzbrut.theater.domain.Seat
import com.aahzbrut.theater.dto.BookingRequest
import com.aahzbrut.theater.mapper.Mapper
import org.springframework.stereotype.Service

@Service
class BookingMapper : Mapper<Booking, BookingRequest> {

    override fun from(source: BookingRequest): Booking {

        val booking = Booking()
        booking.seat = Seat(source.seatId)
        booking.performance = Performance(source.performanceId)
        booking.customerName = source.customerName

        return booking
    }
}