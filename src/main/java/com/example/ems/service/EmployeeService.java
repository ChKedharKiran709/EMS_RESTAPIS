package com.example.ems.service;

import com.example.ems.exception.EmployeeNotFoundException;
import com.example.ems.exception.InvalidInputException;
import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Add Employee
    public Employee addEmployee(Employee employee) {
        // Check if the employee ID already exists
        if (employeeRepository.existsById(employee.getId())) {
            throw new InvalidInputException("Employee with ID " + employee.getId() + " already exists");
        }

        if (employee == null || employee.getName() == null || employee.getName().trim().isEmpty()) {
            throw new InvalidInputException("Employee or Employee name cannot be null");
        }
        return employeeRepository.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee by ID
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        return employee.get();
    }

    // Update Employee by ID
    public Employee updateEmployeeById(int id, Employee employeeDetails) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }

        // Validate that the employee name is not null or empty
        if (employeeDetails.getName() == null || employeeDetails.getName().trim().isEmpty()) {
            throw new InvalidInputException("Employee or Employee name cannot be null or empty");
        }

        // Update the employee details
        employeeDetails.setId(id);
        return employeeRepository.save(employeeDetails);
    }

    // Delete Employee by ID
    public void deleteEmployeeById(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }
}
