package com.devfun.employeeservice.employee;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final ModelMapper mapper;

    @Override
    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = mapper.map(employeeDto, Employee.class);
        DepartmentResponse departmentResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/departments/name/{departmentName}",
                DepartmentResponse.class,
                employeeDto.getDepartmentName()
        );
        if (departmentResponse == null) {
            throw new IllegalArgumentException("Department not found");
        }
        employee.setDepartmentId(departmentResponse.getDepartmentId());
        employeeRepository.save(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(emp -> mapper.map(emp, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .map(emp -> mapper.map(emp, EmployeeDto.class))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id "+ employeeId+ " not found"));
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employee) {
        return employeeRepository.findById(employeeId)
                .map(emp -> {
                    emp.setName(employee.getName());
                    emp.setEmail(employee.getEmail());
                    emp.setGender(employee.getGender());

                    return mapper.map(employeeRepository.save(emp), EmployeeDto.class);
                }).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
