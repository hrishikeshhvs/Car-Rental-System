package com.ey.service;

import com.ey.dto.damage.DamageReportRequest;
import com.ey.entity.Car;
import com.ey.entity.DamageReport;
import com.ey.entity.User;
import com.ey.repository.CarRepository;
import com.ey.repository.DamageReportRepository;
import com.ey.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DamageReportService {

    private final DamageReportRepository damageReportRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public String reportDamage(DamageReportRequest request) {
        Car car = carRepository.findById(request.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        DamageReport report = DamageReport.builder()
                .car(car)
                .user(user)
                .description(request.getDescription())
                .severity(request.getSeverity())
                .build();

        damageReportRepository.save(report);
        return "Damage report submitted successfully";
    }

    public List<DamageReport> getAllReports() {
        return damageReportRepository.findAll();
    }
}
