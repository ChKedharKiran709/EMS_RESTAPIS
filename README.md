# Employee Management System

## Project Overview
This Employee Management System is built using Spring Boot to perform CRUD operations on employee data. The system uses a MySQL database for data storage, and all REST APIs have been tested using Postman.

---

## Features
- RESTful APIs for managing employees.
- CRUD operations:
  - **Create**: Add a new employee.
  - **Read**: Fetch employee details (single and all).
  - **Update**: Modify existing employee details.
  - **Delete**: Remove an employee.
- Integration with MySQL database.
- Exception Handling:
  - **EmployeeNotFoundException**: Thrown when an employee with the given ID is not found.
  - **InvalidInputException**: Thrown when input validation fails.
  - **GlobalExceptionHandler**: Handles all exceptions globally and returns meaningful responses.

---

## Technologies Used
- **Backend**: Spring Boot
- **Database**: MySQL
- **Build Tool**: Maven
- **Testing**: Postman

---

## Prerequisites
- JDK 17 or above
- Maven
- MySQL Server
- Postman (optional for API testing)

---

## Project Setup

### 1. Clone the Repository
```bash
git clone https://github.com/ChKedharKiran709/EMS_RESTAPIS.git
cd EMS_RESTAPIS
```

### 2. Configure Database
- Create a MySQL database:
  ```sql
  CREATE DATABASE employee_management;
  ```
- Update the database configuration in `application.properties`:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  spring.jpa.hibernate.ddl-auto=update
  ```

### 3. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

The application will start at `http://localhost:8080`.

---

## API Endpoints

### 1. Add a New Employee
- **POST** `/api/employees`
- **Request Body**:
  ```json
  {
    "name": "Ch Kedhar Kiran",
    "email": "chkedharkiran@gmail.com",
    "phone": "+1234567890",
    "designation": "Software Engineer",
    "department": "IT",
    "dateOfJoining": "2024-01-15",
    "salary": 75000.00,
    "dob": "1990-05-10",
    "gender": "Male",
    "address": "Bengaluru, India",
    "employmentType": "Full-Time",
    "managerId": 101,
    "location": "Bengaluru Office",
    "status": "Active",
    "profilePictureUrl": "http://example.com/images/john_doe.jpg"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "name": "Ch Kedhar Kiran",
    "email": "chkedharkiran@gmail.com",
    "phone": "+1234567890",
    "designation": "Software Engineer",
    "department": "IT",
    "dateOfJoining": "2024-01-15",
    "salary": 75000.00,
    "dob": "1990-05-10",
    "gender": "Male",
    "address": "Bengaluru, India",
    "employmentType": "Full-Time",
    "managerId": 101,
    "location": "Bengaluru Office",
    "status": "Active",
    "profilePictureUrl": "http://example.com/images/john_doe.jpg"
  }
  ```

### 2. Fetch All Employees
- **GET** `/api/employees`
- **Response**:
  ```json
  [
    {
      "id": 1,
      "name": "Ch Kedhar Kiran",
      "email": "chkedharkiran@gmail.com",
      "phone": "+1234567890",
      "designation": "Software Engineer",
      "department": "IT",
      "dateOfJoining": "2024-01-15",
      "salary": 75000.00,
      "dob": "1990-05-10",
      "gender": "Male",
      "address": "Bengaluru, India",
      "employmentType": "Full-Time",
      "managerId": 101,
      "location": "Bengaluru Office",
      "status": "Active",
      "profilePictureUrl": "http://example.com/images/john_doe.jpg"
    }
  ]
  ```

### 3. Fetch Employee by ID
- **GET** `/api/employees/{id}`
- **Response**:
  ```json
  {
    "id": 1,
    "name": "Ch Kedhar Kiran",
    "email": "chkedharkiran@gmail.com",
    "phone": "+1234567890",
    "designation": "Software Engineer",
    "department": "IT",
    "dateOfJoining": "2024-01-15",
    "salary": 75000.00,
    "dob": "1990-05-10",
    "gender": "Male",
    "address": "Bengaluru, India",
    "employmentType": "Full-Time",
    "managerId": 101,
    "location": "Bengaluru Office",
    "status": "Active",
    "profilePictureUrl": "http://example.com/images/john_doe.jpg"
  }
  ```

- **Exception**:
  If the employee ID is not found:
  ```json
  {
    "error": "EmployeeNotFoundException",
    "message": "Employee with ID 99 not found",
    "timestamp": "2025-01-02T12:34:56"
  }
  ```

### 4. Update an Employee
- **PUT** `/api/employees/{id}`
- **Request Body**:
  ```json
  {
    "name": "Ch Kedhar Kiran",
    "email": "chkedharkiran_updated@gmail.com",
    "phone": "+9876543210",
    "designation": "Senior Software Engineer",
    "department": "IT",
    "dateOfJoining": "2024-01-15",
    "salary": 85000.00,
    "dob": "1990-05-10",
    "gender": "Male",
    "address": "Hyderabad, India",
    "employmentType": "Full-Time",
    "managerId": 102,
    "location": "Hyderabad Office",
    "status": "Active",
    "profilePictureUrl": "http://example.com/images/john_doe_updated.jpg"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "name": "Ch Kedhar Kiran",
    "email": "chkedharkiran_updated@gmail.com",
    "phone": "+9876543210",
    "designation": "Senior Software Engineer",
    "department": "IT",
    "dateOfJoining": "2024-01-15",
    "salary": 85000.00,
    "dob": "1990-05-10",
    "gender": "Male",
    "address": "Hyderabad, India",
    "employmentType": "Full-Time",
    "managerId": 102,
    "location": "Hyderabad Office",
    "status": "Active",
    "profilePictureUrl": "http://example.com/images/john_doe_updated.jpg"
  }
  ```

- **Exception**:
  If input validation fails:
  ```json
  {
    "error": "InvalidInputException",
    "message": "Salary must be greater than 0",
    "timestamp": "2025-01-02T12:34:56"
  }
  ```

### 5. Delete an Employee
- **DELETE** `/api/employees/{id}`
- **Response**: `204 No Content`

- **Exception**:
  If the employee ID is not found:
  ```json
  {
    "error": "EmployeeNotFoundException",
    "message": "Employee with ID 99 not found",
    "timestamp": "2025-01-02T12:34:56"
  }
  ```

---

## Directory Structure
```
src/main/java
├── com.example.employeemanagement
│   ├── controller       # REST controllers
│   ├── entity           # Entity classes
│   ├── repository       # JPA repositories
│   ├── service          # Business logic
│   ├── exception        # Custom exceptions and handlers
src/main/resources
├── application.properties
```

---

## Sample Employee Data
```json
{
  "id": 1,
  "name": "Ch Kedhar Kiran",
  "email": "chkedharkiran@gmail.com",
  "phone": "+1234567890",
  "designation": "Software Engineer",
  "department": "IT",
  "dateOfJoining": "2024-01-15",
  "salary": 75000.00,
  "dob": "1990-05-10",
  "gender": "Male",
  "address": "Bengaluru, India",
  "employmentType": "Full-Time",
  "managerId": 101,
  "location": "Bengaluru Office",
  "status": "Active",
  "profilePictureUrl": "http://example.com/images/john_doe.jpg"
}
```
