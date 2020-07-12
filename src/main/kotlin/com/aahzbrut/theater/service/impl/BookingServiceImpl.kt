package com.aahzbrut.theater.service.impl

import com.aahzbrut.theater.domain.Booking
import com.aahzbrut.theater.dto.BookingRequest
import com.aahzbrut.theater.dto.BookingResponse
import com.aahzbrut.theater.dto.PerformanceResponse
import com.aahzbrut.theater.dto.SeatResponse
import com.aahzbrut.theater.mapper.Mapper
import com.aahzbrut.theater.repository.BookingRepository
import com.aahzbrut.theater.service.BookingService
import org.springframework.stereotype.Service

@Service
class BookingServiceImpl(
        val bookingRepository: BookingRepository,
        val bookingResponseMapper: Mapper<BookingResponse, Booking>,
        val bookingMapper: Mapper<Booking, BookingRequest>) : BookingService {

    override fun isSeatFree(seat: SeatResponse, performance: PerformanceResponse?): Boolean =
            !bookingRepository.existsBySeatIdAndPerformanceId(seat.id, performance!!.id)

    override fun reserveSeat(bookingRequest: BookingRequest): BookingResponse {

        val booking = bookingMapper.from(bookingRequest)
        bookingRepository.saveAndFlush(booking)

        return bookingResponseMapper.from(booking)
    }

    override fun findBooking(seat: SeatResponse, performance: PerformanceResponse): BookingResponse? =
            bookingResponseMapper.from(bookingRepository.getBySeatIdAndPerformanceId(seat.id, performance.id))
}