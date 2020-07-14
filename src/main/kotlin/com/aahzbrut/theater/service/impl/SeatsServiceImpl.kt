package com.aahzbrut.theater.service.impl

import com.aahzbrut.theater.domain.Seat
import com.aahzbrut.theater.dto.SeatResponse
import com.aahzbrut.theater.mapper.Mapper
import com.aahzbrut.theater.repository.SeatRepository
import com.aahzbrut.theater.service.SeatsService
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class SeatsServiceImpl(
        val seatRepository: SeatRepository,
        val seatResponseMapper: Mapper<SeatResponse, Seat>) : SeatsService {

    override fun initRepository() {

        if (seatRepository.count() > 0) return

        val hiddenSeats = getDefaultSeatsProps()

        seatRepository.saveAll(hiddenSeats)
        seatRepository.flush()
    }

    override fun getSeat(row: Char, num: Int): SeatResponse =
            seatResponseMapper.from(seatRepository.getByRowAndNum(row, num))

    override fun getOne(id: Long): SeatResponse =
        seatResponseMapper.from(seatRepository.getOne(id))

    private fun getDefaultSeatsProps(): MutableList<Seat> {
        val hiddenSeats = mutableListOf<Seat>()

        for (row in 1..15) {
            for (num in 1..36) {
                val rowChar = (row + 64).toChar()
                val seat = Seat(0)
                seat.row = rowChar
                seat.num = num
                seat.description = getDescription(row, num)
                seat.price = getPrice(row, num)
                hiddenSeats.add(seat)
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