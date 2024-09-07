package com.example.app.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PatientProfileEditBody {

    private int id;

    @NotEmpty(message = "Full name is required")
    @Size(min = 3, max = 30, message = "Full name should be 3 to 30 characters long.")
    private String fullName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Valid email is required")
    private String email;

    // private String password;

    @NotEmpty(message = "Mobile number is required")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits long")
    private String mobileNumber;

    // private String gender;

    // private LocalDate dob;

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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PatientProfileEditBody [id=" + id + ", fullName=" + fullName + ", email=" + email + ", mobileNumber="
                + mobileNumber + ", address=" + address + "]";
    }

}
