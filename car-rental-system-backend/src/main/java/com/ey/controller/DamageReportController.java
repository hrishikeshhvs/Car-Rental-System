package com.ey.controller;

import com.ey.dto.damage.DamageReportRequest;
import com.ey.entity.DamageReport;
import com.ey.service.DamageReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/damages")
@RequiredArgsConstructor
public class DamageReportController {

    private final DamageReportService damageReportService;

    @PostMapping
    public ResponseEntity<String> reportDamage(@Valid @RequestBody DamageReportRequest request) {
        String message = damageReportService.reportDamage(request);
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity<List<DamageReport>> getAllReports() {
        return ResponseEntity.ok(damageReportService.getAllReports());
    }
}
