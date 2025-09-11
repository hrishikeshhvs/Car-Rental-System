package com.ey.service;

import com.ey.dto.car.CarRequest;
import com.ey.dto.car.CarResponse;
import com.ey.entity.Car;
import com.ey.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public CarResponse addCar(CarRequest request) {
        Car car = Car.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .registrationNumber(request.getRegistrationNumber())
                .pricePerDay(request.getPricePerDay())
                .status(request.getStatus())
                .build();

        Car savedCar = carRepository.save(car);
        return mapToResponse(savedCar);
    }

    public List<CarResponse> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public CarResponse updateCar(Long id, CarRequest request) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        car.setBrand(request.getBrand());
        car.setModel(request.getModel());
        car.setRegistrationNumber(request.getRegistrationNumber());
        car.setPricePerDay(request.getPricePerDay());
        car.setStatus(request.getStatus());

        Car updatedCar = carRepository.save(car);
        return mapToResponse(updatedCar);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    private CarResponse mapToResponse(Car car) {
        return new CarResponse(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getRegistrationNumber(),
                car.getPricePerDay(),
                car.getStatus()
        );
    }
}
