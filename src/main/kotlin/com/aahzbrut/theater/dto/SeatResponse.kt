package com.aahzbrut.theater.dto

import java.math.BigDecimal

class SeatResponse (
        val id: Long,
        val row: Char,
        val num: Int,
        val price: BigDecimal,
        val description: String){

    override fun toString(): String = "Seat $row-$num $$price ($description)"
}