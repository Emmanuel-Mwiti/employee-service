package io.github.emmanuelmwiti.employee_service.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import io.github.emmanuelmwiti.employee_service.dto.EmployeeCreateRequest;
import io.github.emmanuelmwiti.employee_service.dto.EmployeeResponse;
import io.github.emmanuelmwiti.employee_service.entity.Employee;
import io.github.emmanuelmwiti.employee_service.repository.EmployeeRepository;
import io.github.emmanuelmwiti.employee_service.service.EmployeeService;
import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public EmployeeResponse createEmployee(@Valid EmployeeCreateRequest employeeCreateRequest) {
        Employee empReq = modelMapper.map(employeeCreateRequest, Employee.class);
        var savedEmployee = employeeRepository.save(empReq);
        return modelMapper.map(savedEmployee, EmployeeResponse.class);
    }
}
