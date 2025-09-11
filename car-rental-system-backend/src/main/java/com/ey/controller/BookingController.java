package com.ey.controller;

import com.ey.dto.booking.BookingRequest;
import com.ey.dto.booking.BookingResponse;
import com.ey.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@Valid @RequestBody BookingRequest request) {
        BookingResponse response = bookingService.createBooking(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getUserBookings() {
        return ResponseEntity.ok(bookingService.getUserBookings());
    }
}
