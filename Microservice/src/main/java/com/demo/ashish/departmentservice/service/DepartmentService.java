package com.demo.ashish.departmentservice.service;

import com.demo.ashish.departmentservice.entity.Department;
import com.demo.ashish.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department getDepartmentById(Long departmentId) {
        log.info("Inside the getDepartmentById Method of the DepartmentService");
        return departmentRepository.findById(departmentId).get();
    }
    public Department saveDepartment(Department department)
    {
        log.info("Inside the saveDepartment Method of the DepartmentService");
        return departmentRepository.saveAndFlush(department);

    }

    public List<Department> getAllDepartments() {
        log.info("Inside the getAllDepartments Method of the DepartmentService");
        return departmentRepository.findAll();
    }
}
