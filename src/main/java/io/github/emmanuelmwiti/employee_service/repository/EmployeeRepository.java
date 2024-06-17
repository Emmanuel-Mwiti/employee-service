package io.github.emmanuelmwiti.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.emmanuelmwiti.employee_service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    
}
