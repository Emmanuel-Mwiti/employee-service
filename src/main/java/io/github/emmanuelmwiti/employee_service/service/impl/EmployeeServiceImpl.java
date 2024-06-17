package io.github.emmanuelmwiti.employee_service.service.impl;

import java.util.List;

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

    @Override
    public List<EmployeeResponse> listAll() {
        return employeeRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, EmployeeResponse.class))
                .toList();
    }

    @Override
    public EmployeeResponse findByEmployeeNumber(Integer employeeNumber) {
        return employeeRepository.findById(employeeNumber)
                .map(e -> modelMapper.map(e, EmployeeResponse.class))
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public String deleteByEmployeeNumber(Integer employeeNumber) {
        employeeRepository.deleteById(employeeNumber);
        return "success";
    }
}
