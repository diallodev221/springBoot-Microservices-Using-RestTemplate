package com.devfun.employeeservice.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/employees")
public interface EmployeeApi {
    @GetMapping
    List<EmployeeDto> getAllEmployees();
    @PostMapping
    void addEmployee(@RequestBody EmployeeDto employeeDto);
    @GetMapping("/{id}")
    EmployeeDto getEmployeeById(@PathVariable("id") Long employeeId);
    @PutMapping("/{id}")
    EmployeeDto updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto);
    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable("id") Long employeeId);
}
