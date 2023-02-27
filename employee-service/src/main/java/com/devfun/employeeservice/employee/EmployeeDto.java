package com.devfun.employeeservice.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeDto {
    private String name;
    private String email;
    private String gender;
    private String departmentName;
}
