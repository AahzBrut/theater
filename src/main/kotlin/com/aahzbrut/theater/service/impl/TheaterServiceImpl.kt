package com.aahzbrut.theater.service.impl

import com.aahzbrut.theater.dto.SeatResponse
import com.aahzbrut.theater.mapper.impl.SeatResponseMapper
import com.aahzbrut.theater.service.SeatsService
import com.aahzbrut.theater.service.TheaterService
import org.springframework.stereotype.Service


@Service
class TheaterServiceImpl(
        val seatsService: SeatsService) : TheaterService {

    override fun findSeat(num: Int, row: Char): SeatResponse =
            seatsService.getSeat(row, num)

    override fun bootStrap() {

        seatsService.initRepository()
    }

    override fun getOne(id: Long): SeatResponse {

        return seatsService.getOne(id)
    }
}
