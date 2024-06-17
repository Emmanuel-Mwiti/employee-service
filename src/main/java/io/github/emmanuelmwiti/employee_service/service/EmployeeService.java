package io.github.emmanuelmwiti.employee_service.service;

import io.github.emmanuelmwiti.employee_service.dto.EmployeeCreateRequest;
import io.github.emmanuelmwiti.employee_service.dto.EmployeeResponse;
import jakarta.validation.Valid;

public interface EmployeeService {

    EmployeeResponse createEmployee(@Valid EmployeeCreateRequest employeeCreateRequest);
    
}
