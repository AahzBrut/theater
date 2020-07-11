package com.aahzbrut.theater.controller

import com.aahzbrut.theater.dto.PerformanceAddRequest
import com.aahzbrut.theater.service.PerformanceService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/performances")
class PerformanceController (
        val performanceService: PerformanceService){

    @RequestMapping("")
    fun performanceHomePage() =
            ModelAndView("performances/home", "performances", performanceService.getAll())

    @GetMapping("/add")
    fun addPerformance() =
            ModelAndView("performances/add", "performance", PerformanceAddRequest(0, ""))

    @PostMapping("/save")
    fun savePerformance(request: PerformanceAddRequest) : String {

        performanceService.save(request)
        return "redirect:/performances/"
    }
}