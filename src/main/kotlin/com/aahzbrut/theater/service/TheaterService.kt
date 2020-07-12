package com.aahzbrut.theater.service

import com.aahzbrut.theater.dto.SeatResponse

interface TheaterService {

    fun findSeat(num: Int, row: Char) : SeatResponse

    fun bootStrap()
    fun getOne(id: Long): SeatResponse
}