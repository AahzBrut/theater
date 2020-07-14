package com.aahzbrut.theater.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "SEAT")
@AttributeOverride(name = "id", column = Column(name = "SEAT_ID"))
class Seat (

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "seat")
        val booking: List<Booking> = emptyList(),

        @Column(name = "SEAT_ROW")
        var row: Char,

        @Column(name = "SEAT_NUM")
        var num: Int,

        @Column(name = "PRICE")
        var price: BigDecimal,

        @Column(name = "DESCRIPTION")
        var description: String

) : BaseEntity<Long>() {

        constructor(id: Long?) {
                this.id = id
        }
}