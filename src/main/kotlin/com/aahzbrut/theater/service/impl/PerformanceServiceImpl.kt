package com.aahzbrut.theater.service.impl

import com.aahzbrut.theater.domain.Performance
import com.aahzbrut.theater.dto.PerformanceAddRequest
import com.aahzbrut.theater.dto.PerformanceResponse
import com.aahzbrut.theater.mapper.Mapper
import com.aahzbrut.theater.repository.PerformanceRepository
import com.aahzbrut.theater.service.PerformanceService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PerformanceServiceImpl(
        val performanceRepository: PerformanceRepository,
        val performanceResponseMapper: Mapper<PerformanceResponse, Performance>,
        val performanceMapper: Mapper<Performance, PerformanceAddRequest>
) : PerformanceService {

    @Transactional
    override fun getAll(): List<PerformanceResponse> =
            performanceResponseMapper.from(performanceRepository.findAll())

    @Transactional
    override fun getOne(id: Long): PerformanceResponse =
            performanceResponseMapper.from(performanceRepository.getOne(id))

    @Transactional
    override fun save(request: PerformanceAddRequest) {

        performanceRepository.saveAndFlush(performanceMapper.from(request))
    }
}