package com.demo.ashish.departmentservice.controller;

import com.demo.ashish.departmentservice.entity.Department;
import com.demo.ashish.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/department")
public class DepartmentController {

    @Value("${server.port:0}")
    private int portNumber;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/greeting")
    public String departmentGreeting()
    {
        log.info("Inside the Greeting Method of the DepartmentController");
        return "Greeting from Department Service. The Server Port : "+portNumber;
    }

    @GetMapping("/getdepartment/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId)
    {
        log.info("Inside the getDepartment Method of the DepartmentController");
        return departmentService.getDepartmentById(departmentId);
    }

    @GetMapping("/getdepartments")
    public List<Department> getDepartments()
    {
        log.info("Inside the getDepartments Method of the DepartmentController");
        return departmentService.getAllDepartments();
    }

    @PutMapping("/storedepartment")
    public Department addDepartment(@RequestBody Department department)
    {
        log.info("Inside the addDepartment Method of the DepartmentController");
        return this.departmentService.saveDepartment(department);
    }
}
