package com.aahzbrut.theater.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "SEAT")
data class Seat(
        @Id
        @Column(name = "SEAT_ID")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seatSeqGenerator")
        @SequenceGenerator(name = "seatSeqGenerator", sequenceName = "SEAT_SEQ", initialValue = 1, allocationSize = 1)
        val id: Long,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "seat")
        val booking: List<Booking> = emptyList(),

        @Column(name = "SEAT_ROW")
        val row: Char,

        @Column(name = "SEAT_NUM")
        val num: Int,

        @Column(name = "PRICE")
        val price: BigDecimal,

        @Column(name = "DESCRIPTION")
        val description: String) {

    override fun toString(): String = "Seat $row-$num $$price ($description)"
}