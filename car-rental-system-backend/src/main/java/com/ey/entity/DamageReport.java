package com.ey.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "damage_reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DamageReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String description;

    @Enumerated(EnumType.STRING)
    private DamageSeverity severity;
}

