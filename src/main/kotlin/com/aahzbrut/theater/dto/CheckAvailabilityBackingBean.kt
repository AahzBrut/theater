package com.aahzbrut.theater.dto

class CheckAvailabilityBackingBean {
    var selectedSeatNum: Int = 1
    var selectedSeatRow: Char = 'A'
    var selectedPerformance: Long? = null
    var customerName: String = ""
    var available: Boolean? = null
    var seat: SeatResponse? = null
    var performance: PerformanceResponse? = null
    var booking: BookingResponse? = null
}