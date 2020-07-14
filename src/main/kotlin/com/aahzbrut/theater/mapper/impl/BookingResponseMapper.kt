package com.aahzbrut.theater.mapper.impl

import com.aahzbrut.theater.domain.Booking
import com.aahzbrut.theater.dto.BookingResponse
import com.aahzbrut.theater.mapper.Mapper
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

@Service
class BookingResponseMapper(
        val context: ApplicationContext) : Mapper<BookingResponse, Booking> {



    override fun from(source: Booking): BookingResponse {

        val performanceMapper = context.getBean(PerformanceResponseMapper::class.java)
        val seatMapper = context.getBean(SeatResponseMapper::class.java)

        return BookingResponse(
                source.id,
                performanceMapper.from(source.performance),
                seatMapper.from(source.seat),
                source.customerName)
    }

}