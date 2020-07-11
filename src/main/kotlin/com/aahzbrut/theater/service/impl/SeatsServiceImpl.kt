package com.aahzbrut.theater.service.impl

import com.aahzbrut.theater.domain.Seat
import com.aahzbrut.theater.repository.SeatRepository
import com.aahzbrut.theater.service.SeatsService
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class SeatsServiceImpl(
        val seatRepository: SeatRepository) : SeatsService {

    override fun initRepository() {

        if (seatRepository.count() > 0) return

        val hiddenSeats = getDefaultSeatsProps()

        seatRepository.saveAll(hiddenSeats)
        seatRepository.flush()
    }

    private fun getDefaultSeatsProps(): MutableList<Seat> {
        val hiddenSeats = mutableListOf<Seat>()

        for (row in 1..15) {
            for (num in 1..36) {
                val rowChar = (row + 64).toChar()
                hiddenSeats.add(Seat(0, rowChar, num, getPrice(row, num), getDescription(row, num)))
            }
        }
        return hiddenSeats
    }

    private fun getPrice(row: Int, num: Int): BigDecimal {
        return when {
            row >= 14 -> BigDecimal(14.50)
            num <= 3 || num >= 34 -> BigDecimal(16.50)
            row == 1 -> BigDecimal(21)
            else -> BigDecimal(18)
        }

    }

    private fun getDescription(row: Int, num: Int): String {
        return when {
            row == 15 -> "Back Row"
            row == 14 -> "Cheaper Seat"
            num <= 3 || num >= 34 -> "Restricted View"
            row <= 2 -> "Best View"
            else -> "Standard Seat"
        }
    }

}