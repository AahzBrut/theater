package com.aahzbrut.theater.service

import com.aahzbrut.theater.domain.Seat

interface TheaterService {

    fun findSeat(num: Int, row: Char) : Seat

    fun bootStrap()
}