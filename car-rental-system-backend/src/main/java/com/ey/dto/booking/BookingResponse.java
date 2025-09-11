package com.ey.dto.booking;

import com.ey.entity.BookingStatus;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {

    private Long id;
    private Long carId;
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BookingStatus status;
}
