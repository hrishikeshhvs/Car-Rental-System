package com.ey.dto.damage;

import com.ey.entity.DamageSeverity;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DamageReportRequest {

    @NotNull
    private Long carId;

    @NotBlank
    private String description;

    @NotNull
    private DamageSeverity severity;
}
