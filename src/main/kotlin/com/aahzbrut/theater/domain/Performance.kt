package com.aahzbrut.theater.domain

import javax.persistence.*

@Entity(name = "PERFORMANCE")
data class Performance(
        @Id
        @Column(name = "PERFORMANCE_ID")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "performanceSeqGenerator")
        @SequenceGenerator(name = "performanceSeqGenerator", sequenceName = "PERFORMANCE_SEQ", initialValue = 1, allocationSize = 1)
        val id: Long,

        @Column(name = "NAME")
        val title: String) {

    override fun toString(): String = "$id: $title"
}