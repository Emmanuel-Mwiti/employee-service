package io.github.emmanuelmwiti.employee_service.service;

import java.util.List;

import io.github.emmanuelmwiti.employee_service.dto.EmployeeCreateRequest;
import io.github.emmanuelmwiti.employee_service.dto.EmployeeResponse;
import jakarta.validation.Valid;

public interface EmployeeService {

    EmployeeResponse createEmployee(@Valid EmployeeCreateRequest employeeCreateRequest);

    List<EmployeeResponse> listAll();

    EmployeeResponse findByEmployeeNumber(Integer employeeNumber);

    String deleteByEmployeeNumber(Integer employeeNumber);
    
}
