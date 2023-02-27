package com.devfun.employeeservice.employee;

import lombok.Data;

@Data
public class DepartmentResponse {
    private Long departmentId;
    private String name;
    private String description;
}
