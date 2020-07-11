package com.aahzbrut.theater.service.impl

import com.aahzbrut.theater.dto.PerformanceResponse
import com.aahzbrut.theater.dto.SeatResponse
import com.aahzbrut.theater.repository.BookingRepository
import com.aahzbrut.theater.service.BookingService
import org.springframework.stereotype.Service

@Service
class BookingServiceImpl(
        val bookingRepository: BookingRepository) : BookingService {

    override fun isSeatFree(seat: SeatResponse, performance: PerformanceResponse?): Boolean {

        if (performance != null) {
           return !bookingRepository.existsBySeatIdAndPerformanceId(seat.id, performance.id)
        }
        return false
    }
}