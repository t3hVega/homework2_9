package com.homework.homework29.service;

import com.homework.homework29.model.Employee;
import com.homework.homework29.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer salary, Integer departmentId);
    void removeEmployee(String firstName, String lastName);
    Map<String, Employee> staff();
    Employee findEmployee(String firstName, String lastname);
    Integer getMaxSalary(Integer departmentId);
}
