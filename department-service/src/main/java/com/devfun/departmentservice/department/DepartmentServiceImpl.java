package com.devfun.departmentservice.department;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department with id "+ departmentId+ " not found"));
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByName(departmentName)
                .orElseThrow(() -> new DepartmentNotFoundException("Department with name "+ departmentName+ " not found"));
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        return departmentRepository.findById(departmentId)
                .map(oldDepartment -> {
                    oldDepartment.setName(department.getName());
                    oldDepartment.setDescription(department.getDescription());
                    return departmentRepository.save(oldDepartment);
                }).orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
    }

    @Override
    public void deleteDepartment(Long DepartmentId) {
        departmentRepository.deleteById(DepartmentId);
    }
}
