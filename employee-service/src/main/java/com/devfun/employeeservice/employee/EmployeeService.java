package com.devfun.employeeservice.employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(EmployeeDto employee);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long employeeId);

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employee);
    void deleteEmployee(Long employeeId);
}
