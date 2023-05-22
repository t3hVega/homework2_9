package com.homework.homework29.controller;

import com.homework.homework29.model.Employee;
import com.homework.homework29.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(
            @RequestParam("departmentId")
            Integer departmentId
    ) {
       return departmentService.maxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(
            @RequestParam("departmentId")
            Integer departmentId
    ) {
        return departmentService.minSalary(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all(
            @RequestParam(name = "departmentId", required = false)
            Integer departmentId
    ) {
        return departmentService.all(departmentId);
    }

}
