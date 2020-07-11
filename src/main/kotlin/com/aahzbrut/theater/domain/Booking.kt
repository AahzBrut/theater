package com.aahzbrut.theater.domain

import javax.persistence.*

@Entity(name = "BOOKING")
data class Booking(
        @Id
        @Column(name = "BOOKING_ID")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingSeqGenerator")
        @SequenceGenerator(name = "bookingSeqGenerator", sequenceName = "BOOKING_SEQ", initialValue = 1, allocationSize = 1)
        val id: Long,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "PERFORMANCE_ID")
        val performance: Performance,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "SEAT_ID")
        val seat: Seat,

        @Column(name = "CUSTOMER_NAME")
        val customerName: String
)