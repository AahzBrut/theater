package com.aahzbrut.theater.domain

import javax.persistence.*

@Entity(name = "BOOKING")
@AttributeOverride(name = "id", column = Column(name = "BOOKING_ID"))
class Booking(

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "PERFORMANCE_ID")
        var performance: Performance,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "SEAT_ID")
        var seat: Seat,

        @Column(name = "CUSTOMER_NAME")
        var customerName: String

) : BaseEntity<Long>()