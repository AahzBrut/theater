package com.aahzbrut.theater.domain

import javax.persistence.*

@Entity(name = "BOOKING")
@AttributeOverride(name = "id", column = Column(name = "BOOKING_ID"))
class Booking : BaseEntity {

        constructor(id: Long? = null) : super() {
                this.id = id
        }

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "PERFORMANCE_ID")
        var performance: Performance? = null

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "SEAT_ID")
        var seat: Seat? = null

        @Column(name = "CUSTOMER_NAME")
        var customerName: String? = null
}