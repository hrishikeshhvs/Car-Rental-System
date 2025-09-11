package com.ey.dto.car;

import com.ey.entity.CarStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotBlank
    private String registrationNumber;

    @NotNull
    private Double pricePerDay;

    @NotNull
    private CarStatus status;
}


