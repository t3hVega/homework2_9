package com.homework.homework29.controller;

import com.homework.homework29.service.EmployeeService;
import com.homework.homework29.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("salary") Integer salary,
            @RequestParam("departmentId") Integer departmentId
    ) {
        return employeeService.addEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/remove")
    public void remove(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/staff")
    public Map<String,Employee> staff() {
        return employeeService.staff();
    }
}
