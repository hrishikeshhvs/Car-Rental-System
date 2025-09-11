package com.ey.dto.auth;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String role;
}
