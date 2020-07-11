package com.aahzbrut.theater.mapper

import com.aahzbrut.theater.domain.Seat
import com.aahzbrut.theater.dto.SeatResponse
import org.springframework.stereotype.Service

@Service
class SeatResponseMapper : Mapper<SeatResponse, Seat> {

    override fun from(source: Seat): SeatResponse =
            SeatResponse(
                    source.id,
                    source.row,
                    source.num,
                    source.price,
                    source.description
            )
}