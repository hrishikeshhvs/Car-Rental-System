package com.ey.dto.booking;

import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

    @NotNull
    private Long carId;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;
}
