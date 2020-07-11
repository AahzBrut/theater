package com.aahzbrut.theater.service.impl

import com.aahzbrut.theater.domain.Seat
import com.aahzbrut.theater.service.SeatsService
import com.aahzbrut.theater.service.TheaterService
import org.springframework.stereotype.Service


@Service
class TheaterServiceImpl(
        val seatsService: SeatsService) : TheaterService {

    override fun findSeat(num: Int, row: Char): Seat {
        TODO("Not yet implemented")
    }

    override fun bootStrap() {

        seatsService.initRepository()
    }
}
