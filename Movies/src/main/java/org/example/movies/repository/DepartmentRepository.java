package org.example.movies.repository;

import org.example.movies.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findByDepartmentName(String name);
}