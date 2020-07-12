package com.aahzbrut.theater.repository

import com.aahzbrut.theater.domain.Booking
import com.aahzbrut.theater.domain.Performance
import com.aahzbrut.theater.domain.Seat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PerformanceRepository : JpaRepository<Performance, Long>

@Repository
interface SeatRepository : JpaRepository<Seat, Long> {

    fun getByRowAndNum(row: Char, num: Int): Seat
}

interface BookingRepository : JpaRepository<Booking, Long> {

    fun existsBySeatIdAndPerformanceId(seatId: Long, performanceId: Long): Boolean
    fun getBySeatIdAndPerformanceId(seatId: Long, performanceId: Long): Booking
}