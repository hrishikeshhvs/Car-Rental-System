# 📦 API Documentation

## 🔐 Authentication

### 1. User Registration
**POST** `/auth/register`

**Request Body:**
```json
{
  "fullName": "John Doe",
  "email": "john@example.com",
  "phone": "+911234567890",
  "password": "StrongPass123"
}
```

**Response (201 Created):**
```json
{
  "id": "usr_123",
  "fullName": "John Doe",
  "email": "john@example.com",
  "role": "USER"
}
```

---

### 2. User Login
**POST** `/auth/login`

**Request Body:**
```json
{
  "email": "john@example.com",
  "password": "StrongPass123"
}
```

**Response (200 OK):**
```json
{
  "status": "success",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVC...",
  "role": "USER"
}
```

---

## 🚗 Car APIs

### 3. List a Car
**POST** `/users/cars`

**Request Body:**
```json
{
  "title": "Hyundai i20 Asta",
  "brand": "Hyundai",
  "model": "i20",
  "type": "HATCHBACK",
  "registrationNumber": "KL-01-AB-1234",
  "seats": 5,
  "fuelType": "PETROL",
  "transmission": "MANUAL",
  "location": {
    "city": "Trivandrum",
    "state": "Kerala"
  },
  "pricePerHour": 200,
  "pricePerDay": 1400,
  "deposit": 2000
}
```

**Response (201 Created):**
```json
{
  "status": "success",
  "message": "Car listed successfully. Awaiting admin approval.",
  "carId": "car_101"
}
```

---

### 4. Search Cars
**GET** `/cars?city=Trivandrum&type=SEDAN&minPrice=500&maxPrice=2000`

**Response (200 OK):**
```json
[
  {
    "id": "car_101",
    "title": "Hyundai i20 Asta",
    "pricePerDay": 1400,
    "status": "ACTIVE"
  }
]
```

---

## 📅 Rental APIs

### 5. Book a Car
**POST** `/rentals`

**Request Body:**
```json
{
  "carId": "car_101",
  "startTime": "2025-09-15T10:00:00",
  "endTime": "2025-09-15T18:00:00",
  "pickupLocation": "Technopark Phase 1",
  "dropoffLocation": "Technopark Phase 1"
}
```

**Response (201 Created):**
```json
{
  "status": "success",
  "message": "Car booked successfully",
  "rentalId": "rnt_501"
}
```

---

### 6. Return Car
**POST** `/rentals/{id}/return`

**Request Body:**
```json
{
  "actualReturnTime": "2025-09-15T19:00:00"
}
```

**Response (200 OK):**
```json
{
  "status": "success",
  "message": "Car returned successfully",
  "lateFee": 200
}
```

---

## 🛠 Admin APIs

### 7. Approve Car Listing
**POST** `/admin/cars/{id}/approve`

**Response (200 OK):**
```json
{
  "status": "success",
  "message": "Car approved successfully"
}
```

---

### 8. Block User
**PATCH** `/admin/users/{id}/block`

**Response (200 OK):**
```json
{
  "status": "success",
  "message": "User blocked successfully"
}
```
