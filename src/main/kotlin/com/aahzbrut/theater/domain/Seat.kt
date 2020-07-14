package com.aahzbrut.theater.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "SEAT")
@AttributeOverride(name = "id", column = Column(name = "SEAT_ID"))
class Seat : BaseEntity {

        constructor(id: Long? = null) : super() {
                this.id = id
        }

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "seat")
        val booking: List<Booking> = emptyList()

        @Column(name = "SEAT_ROW")
        var row: Char? = null

        @Column(name = "SEAT_NUM")
        var num: Int? = null

        @Column(name = "PRICE")
        var price: BigDecimal? = null

        @Column(name = "DESCRIPTION")
        var description: String? = null
}