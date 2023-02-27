package com.devfun.departmentservice.department;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class DepartmentController implements DepartmentApi {

    private final DepartmentService departmentService;


    @Override
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @Override
    public void addDepartment(Department department) {
        departmentService.addDepartment(department);
    }

    @Override
    public Department getDepartmentById(Long DepartmentId) {
        return departmentService.getDepartmentById(DepartmentId);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }

    @Override
    public Department updateDepartment(Long DepartmentId, Department department) {
        return departmentService.updateDepartment(DepartmentId, department);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentService.deleteDepartment(departmentId);
    }
}
