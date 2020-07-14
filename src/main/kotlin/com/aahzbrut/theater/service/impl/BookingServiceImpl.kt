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
import javax.transaction.Transactional

@Service
class BookingServiceImpl(
        val bookingRepository: BookingRepository,
        val bookingResponseMapper: Mapper<BookingResponse, Booking>,
        val bookingMapper: Mapper<Booking, BookingRequest>) : BookingService {

    @Transactional
    override fun isSeatFree(seat: SeatResponse, performance: PerformanceResponse?): Boolean =
            !bookingRepository.existsBySeatIdAndPerformanceId(seat.id, performance!!.id)

    @Transactional
    override fun addBooking(bookingRequest: BookingRequest) : Long {

        val booking = bookingMapper.from(bookingRequest)
        bookingRepository.saveAndFlush(booking)

        return booking.id!!
    }

    @Transactional
    override fun getBooking(bookingId: Long): BookingResponse {

        return bookingResponseMapper.from(bookingRepository.getOne(bookingId))
    }

    @Transactional
    override fun findBooking(seat: SeatResponse, performance: PerformanceResponse): BookingResponse? =
            bookingResponseMapper.from(bookingRepository.getBySeatIdAndPerformanceId(seat.id, performance.id))
}