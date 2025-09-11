package com.ey.carrental.service;

import com.ey.carrental.dto.LoginRequest;
import com.ey.carrental.dto.RegisterRequest;
import com.ey.carrental.dto.AuthResponse;

public interface UserService {
    String register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
