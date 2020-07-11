package com.aahzbrut.theater.controller

import com.aahzbrut.theater.dto.CheckAvailabilityBackingBean
import com.aahzbrut.theater.service.BookingService
import com.aahzbrut.theater.service.PerformanceService
import com.aahzbrut.theater.service.TheaterService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class MainController(
        val theaterService: TheaterService,
        val bookingService: BookingService,
        val performanceService: PerformanceService) {

    @RequestMapping("")
    fun homePage(): ModelAndView {

        val model = mapOf("bean" to CheckAvailabilityBackingBean(),
                "performances" to performanceService.getAll(),
                "seatNums" to 1..36,
                "seatRows" to 'A'..'O')

        return ModelAndView("seatBooking", model)
    }

    @PostMapping("/checkAvailability")
    fun checkAvailability(bean: CheckAvailabilityBackingBean): ModelAndView {

        val seat = theaterService.findSeat(bean.selectedSeatNum, bean.selectedSeatRow)
        val performance = performanceService.getOne(bean.selectedPerformance!!)
        bean.available = bookingService.isSeatFree(seat, performance)
        bean.seat = seat
        bean.performance = performance

        val model = mapOf("bean" to bean,
                "performances" to performanceService.getAll(),
                "seatNums" to 1..36,
                "seatRows" to 'A'..'O')

        return ModelAndView("seatBooking", model)
    }

    @GetMapping("bootstrap")
    fun bootStrap(): ModelAndView {

        theaterService.bootStrap()

        return homePage()
    }
}