package com.aahzbrut.theater.dto

import java.math.BigDecimal

data class SeatResponse(
        var id: Long = 0,
        var row: Char = ' ',
        var num: Int = 0,
        var price: BigDecimal = BigDecimal.ZERO,
        var description: String = "") {

        override fun toString(): String = "Seat $row-$num $$price ($description)"
}

