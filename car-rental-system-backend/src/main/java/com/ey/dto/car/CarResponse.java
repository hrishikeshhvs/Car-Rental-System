package com.ey.dto.car;


import com.ey.entity.CarStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {

    private Long id;
    private String brand;
    private String model;
    private String registrationNumber;
    private Double pricePerDay;
    private CarStatus status;
}
