package com.aahzbrut.theater.domain

import javax.persistence.*

@Entity(name = "PERFORMANCE")
@AttributeOverride(name = "id", column = Column(name = "PERFORMANCE_ID"))
class Performance(

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "performance")
        val booking: List<Booking> = emptyList(),

        @Column(name = "NAME")
        var title: String

) : BaseEntity<Long>() {

    constructor(id: Long?) : this(title = "") {
        super.id = id
    }
}