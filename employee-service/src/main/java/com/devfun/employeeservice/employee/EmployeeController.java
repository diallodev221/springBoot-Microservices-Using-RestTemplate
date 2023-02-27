package com.devfun.employeeservice.employee;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class EmployeeController implements EmployeeApi {

    private final EmployeeService employeeService;


    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Override
    public void addEmployee(EmployeeDto employee) {
        employeeService.addEmployee(employee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeId, employeeDto);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
