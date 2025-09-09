# 📄 Project Documentation

## 1. Project Overview

The **Car Rental System** is a full-stack web application that allows users to **rent cars** and **list their own cars for rent**. The platform ensures secure transactions, proper tracking of rentals, and damage reporting. Admins manage approvals, monitor users, and generate system reports.

The system is built using **React.js** for the frontend and **Spring Boot** for the backend. It uses **JWT authentication** for security and **JPA ORM** for database operations.

---

## 2. Core Features and Functionalities

### 🔹 User Features
- Register/Login (JWT-based authentication)
- Search Cars by location, type, and price
- Book Cars for hourly/daily rental
- View Rental History
- Return Cars and update return time

### 🔹 Car Listing Features
- List Cars with details and images
- Set Rental Charges and availability
- Update Car Location
- Report Damages after rental

### 🔹 Admin Features
- Approve Car Listings
- Manage Users (block/unblock)
- View Rental & Damage Reports
- Generate Analytics & Reports

### 🔹 System Features
- JWT-based Authentication & Role-based Access
- Global Exception Handling
- Input Validation
- Standardized API Responses
- CORS Configuration for Frontend Integration

---

## 3. User Roles

1. **Guest User**
   - Can browse available cars
   - Cannot book until registered

2. **Registered User**
   - Can search, book, and return cars
   - Can list and manage their own cars
   - Can view rental history

3. **Administrator**
   - Approve car listings
   - Manage users
   - View reports and analytics

---

## 4. Project Flow

### 🔹 Step 1: Registration & Login
- Users register/login
- JWT token issued for secure access

### 🔹 Step 2: Car Listing
- User adds car details
- Admin approves listing
- Car becomes available for booking

### 🔹 Step 3: Car Search & Booking
- User searches cars by filters
- Books car for selected duration
- Payment status is mocked (integration-ready)

### 🔹 Step 4: Rental & Return
- User picks up car
- Returns car and updates time
- System checks for late return and calculates extra charges

### 🔹 Step 5: Damage Reporting
- Owner inspects car
- If damaged, submits damage report
- Extra charges are added to rental

### 🔹 Step 6: Admin Monitoring
- Admin reviews listings, users, and reports
- Generates analytics and system health reports
