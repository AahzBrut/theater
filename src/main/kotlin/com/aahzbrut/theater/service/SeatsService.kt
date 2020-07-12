package com.aahzbrut.theater.service

import com.aahzbrut.theater.dto.SeatResponse

interface SeatsService {

    fun initRepository()
    fun getSeat(row: Char, num: Int) : SeatResponse
    fun getOne(id: Long): SeatResponse
}