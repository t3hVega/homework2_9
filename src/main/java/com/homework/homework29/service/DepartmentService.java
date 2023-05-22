package com.homework.homework29.service;

import com.homework.homework29.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalary(Integer departmentId);
    Employee minSalary(Integer departmentId);
    Map<Integer, List<Employee>> all(Integer departmentId);
}
