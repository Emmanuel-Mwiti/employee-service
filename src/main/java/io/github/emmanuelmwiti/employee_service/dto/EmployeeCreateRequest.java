package io.github.emmanuelmwiti.employee_service.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.emmanuelmwiti.employee_service.entity.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeCreateRequest {

    @Past(message = "birth date needs to past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private Gender gender;

    @PastOrPresent(message = "hire date needs to past or present")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
}
