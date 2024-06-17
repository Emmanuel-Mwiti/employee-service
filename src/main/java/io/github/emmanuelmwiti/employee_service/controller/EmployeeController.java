package io.github.emmanuelmwiti.employee_service.controller;

import org.springframework.web.bind.annotation.RestController;

import io.github.emmanuelmwiti.employee_service.dto.EmployeeCreateRequest;
import io.github.emmanuelmwiti.employee_service.dto.EmployeeResponse;
import io.github.emmanuelmwiti.employee_service.service.EmployeeService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping
    public List<EmployeeResponse> list() {
        return employeeService.listAll();
    }

    @GetMapping("{employeeNumber}")
    public EmployeeResponse findByEmployeeNumber(@PathVariable(value = "employeeNumber") Integer employeeNumber) {
        return employeeService.findByEmployeeNumber(employeeNumber);
    }

    @DeleteMapping("{employeeNumber}")
    public String deleteByEmployeeNumber(@PathVariable(value = "employeeNumber") Integer employeeNumberr) {
        return employeeService.deleteByEmployeeNumber(employeeNumberr);
    }

}
