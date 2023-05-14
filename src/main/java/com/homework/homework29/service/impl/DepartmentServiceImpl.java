package com.homework.homework29.service.impl;

import com.homework.homework29.model.Employee;
import com.homework.homework29.service.DepartmentService;
import com.homework.homework29.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxSalary(Integer departmentId) {
        return employeeService.staff().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee minSalary(Integer departmentId) {
        return employeeService.staff().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> all(Integer departmentId) {
        return employeeService.staff().values().stream()
                .filter(employee -> departmentId == null || employee.getDepartmentId().equals(departmentId))
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
