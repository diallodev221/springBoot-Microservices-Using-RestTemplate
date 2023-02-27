package com.devfun.departmentservice.department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    void addDepartment(Department department);

    Department getDepartmentById(Long DepartmentId);
    Department getDepartmentByName(String departmentName);

    Department updateDepartment(Long DepartmentId, Department department);

    void deleteDepartment(Long DepartmentId);
}
