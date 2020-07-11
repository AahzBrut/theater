package com.aahzbrut.theater.dto

class CheckAvailabilityBackingBean {

    val seatNums = 1..36
    val seatRows = 'A'..'O'
    var selectedSeatNum: Int = 1
    var selectedSeatRow: Char = 'A'
    var result: String = ""
}