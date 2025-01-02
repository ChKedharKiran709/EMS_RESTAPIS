package com.example.ems.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;

@Entity
@Table(name = "Employee_Details")
public class Employee {

    @Id
    private int id; // Unique Employee ID
    private String name; // Full Name
    private String email; // Email Address
    private String phone; // Phone Number
    private String designation; // Job Title
    private String department; // Department Name
    private Date dateOfJoining; // Joining Date
    private double salary; // Salary
    private Date dob; // Date of Birth
    private String gender; // Gender (Male/Female/Other)
    private String address; // Residential Address
    private String employmentType; // Employment Type (Full-Time, Part-Time, Contractor)
    private int managerId; // Manager ID
    private String location; // Work Location
    private String status; // Employee Status (Active, On Leave, Resigned)
    private String profilePictureUrl; // URL for Profile Picture

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}


/* JSON file for postMapping
{
        "id": 1,
        "name": "Kedhar Kiran",
        "email": "john.doe@example.com",
        "phone": "+1234567890",
        "designation": "Software Engineer",
        "department": "IT",
        "dateOfJoining": "2024-01-15",
        "salary": 75000.00,
        "dob": "1990-05-10",
        "gender": "Male",
        "address": "123 Main Street, City, Country",
        "employmentType": "Full-Time",
        "managerId": 101,
        "location": "New York Office",
        "status": "Active",
        "profilePictureUrl": "http://example.com/images/john_doe.jpg"
        }
*/
