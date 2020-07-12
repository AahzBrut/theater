package com.aahzbrut.theater

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TheaterApplication

fun main(args: Array<String>) {
    runApplication<TheaterApplication>(*args)
}
