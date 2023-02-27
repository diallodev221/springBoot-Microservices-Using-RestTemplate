package com.devfun.departmentservice.department;

import com.devfun.employeeservice.employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "student-service", url = "http://localhost:8080/api/v1/students")
public interface DepartmentProxy {

    @GetMapping("/{id}")
    Employee getStudentById(@PathVariable("id") Long studentId);
}
