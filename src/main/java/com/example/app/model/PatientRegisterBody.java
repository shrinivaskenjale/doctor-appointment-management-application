package com.example.app.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PatientRegisterBody {
    @NotEmpty(message = "Full name is required")
    @Size(min = 3, max = 30, message = "Full name should be 3 to 30 characters long.")
    private String fullName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Valid email is required")
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 8, max = 20, message = "Password should be 8 to 20 characters long.")
    private String password;

    @NotEmpty(message = "Mobile number is required")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits long")
    private String mobileNumber;

    @NotEmpty(message = "Gender is required")
    private String gender;

    @NotNull(message = "Date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date of birth should be in the past")
    private LocalDate dob;

    @NotEmpty(message = "Address is required")
    @Size(min = 8, max = 100, message = "Address should be 8 to 100 characters long.")
    private String address;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
