package com.aahzbrut.theater.controller

import com.aahzbrut.theater.dto.CheckAvailabilityBackingBean
import com.aahzbrut.theater.service.BookingService
import com.aahzbrut.theater.service.TheaterService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class MainController(
        val theaterService: TheaterService,
        val bookingService: BookingService) {

    @RequestMapping("")
    fun homePage() : ModelAndView = ModelAndView("seatBooking", "bean", CheckAvailabilityBackingBean())

    @PostMapping("/checkAvailability")
    fun checkAvailability(bean: CheckAvailabilityBackingBean) : ModelAndView {

        val foundSeat = theaterService.findSeat(bean.selectedSeatNum, bean.selectedSeatRow)
        val result = bookingService.isSeatFree(foundSeat)

        bean.result = "$foundSeat is " + if (result) "available" else "booked"
        return ModelAndView("seatBooking", "bean", bean)
    }

    @GetMapping("bootstrap")
    fun bootStrap() : ModelAndView {
        theaterService.bootStrap()

        return homePage()
    }
}