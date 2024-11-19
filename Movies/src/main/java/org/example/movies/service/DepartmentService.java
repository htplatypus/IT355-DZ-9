package org.example.movies.service;
import org.example.movies.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> findAll();
    Optional<Department> findById(Integer departmentId);
    Department save(Department department);
    Department update(Department department);
    void deleteById(Integer departmentId);
    List<Department> findByName(String name);
}
