package com.example.app.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DoctorRegisterBody {
    @NotEmpty(message = "Full name is required")
    @Size(min = 3, max = 30, message = "Full name should be 3 to 30 characters long.")
    private String fullName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Valid email is required")
    private String email;

    @NotEmpty(message = "Mobile number is required")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits long")
    private String mobileNumber;

    @NotEmpty(message = "Gender is required")
    private String gender;

    @NotEmpty(message = "Specialization is required")
    private String specialization;

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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

}
