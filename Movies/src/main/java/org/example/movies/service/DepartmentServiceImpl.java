package org.example.movies.service;

import org.example.movies.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.movies.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> findById(Integer departmentId) {
        return departmentRepository.findById(departmentId);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Department department) {
        if (departmentRepository.existsById(department.getId())) {
            return departmentRepository.save(department);
        }
        throw new IllegalArgumentException("Department with ID " + department.getId() + " does not exist.");
    }

    @Override
    public void deleteById(Integer departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public List<Department> findByName(String name) {
        return departmentRepository.findByDepartmentName(name); // Assumes this method exists in the repository.
    }
}
