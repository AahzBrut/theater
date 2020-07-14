package com.aahzbrut.theater.domain

import javax.persistence.*

@Entity(name = "BOOKING")
@AttributeOverride(name = "id", column = Column(name = "BOOKING_ID"))
class Booking (

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "PERFORMANCE_ID")
        val performance: Performance,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "SEAT_ID")
        val seat: Seat,

        @Column(name = "CUSTOMER_NAME")
        val customerName: String

) : BaseEntity<Long>() {

        constructor(id: Long?) {
                this.id = id
        }
}