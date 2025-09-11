package com.ey.service;

import com.ey.dto.booking.BookingRequest;
import com.ey.dto.booking.BookingResponse;
import com.ey.entity.*;
import com.ey.repository.BookingRepository;
import com.ey.repository.CarRepository;
import com.ey.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public BookingResponse createBooking(BookingRequest request) {
        Car car = carRepository.findById(request.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = Booking.builder()
                .car(car)
                .user(user)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .status(BookingStatus.PENDING)
                .build();

        Booking savedBooking = bookingRepository.save(booking);
        return mapToResponse(savedBooking);
    }

    public List<BookingResponse> getUserBookings() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookingRepository.findAll()
                .stream()
                .filter(b -> b.getUser().getId().equals(user.getId()))
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private BookingResponse mapToResponse(Booking booking) {
        return new BookingResponse(
                booking.getId(),
                booking.getCar().getId(),
                booking.getUser().getId(),
                booking.getStartDate(),
                booking.getEndDate(),
                booking.getStatus()
        );
    }
}
