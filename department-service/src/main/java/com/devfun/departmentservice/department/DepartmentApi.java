package com.devfun.departmentservice.department;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/departments")
public interface DepartmentApi {
    @GetMapping
    List<Department> getAllDepartments();
    @PostMapping
    void addDepartment(@RequestBody Department department);
    @GetMapping("/{id}")
    Department getDepartmentById(@PathVariable("id") Long departmentId);

    @GetMapping("/name/{name}")
    Department getDepartmentByName(@PathVariable("name") String departmentName);
    @PutMapping("/{id}")
    Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department);
    @DeleteMapping("/{id}")
    void deleteDepartment(@PathVariable("id") Long departmentId);
}
