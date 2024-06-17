package io.github.emmanuelmwiti.employee_service.controller;

import org.springframework.web.bind.annotation.RestController;

import io.github.emmanuelmwiti.employee_service.dto.EmployeeCreateRequest;
import io.github.emmanuelmwiti.employee_service.dto.EmployeeResponse;
import io.github.emmanuelmwiti.employee_service.service.EmployeeService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping    
    public EmployeeResponse create(@RequestBody @Valid EmployeeCreateRequest employeeCreateRequest) {
        return employeeService.createEmployee(employeeCreateRequest);

    }

}
