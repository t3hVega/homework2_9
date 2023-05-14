package com.homework.homework29.service.impl;

import com.homework.homework29.exceptions.EmployeeAlreadyAddedException;
import com.homework.homework29.exceptions.EmployeeNotFoundException;
import com.homework.homework29.exceptions.EmployeeStorageIsFullException;
import com.homework.homework29.model.Employee;
import com.homework.homework29.service.EmployeeService;
import com.homework.homework29.model.Employee;
import com.homework.homework29.service.EmployeeService;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int staffSize = 5;
    private final Map<String, Employee> employees = new HashMap<>();
    @Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer departmentId) {
        String employeeKey = getEmployeeKey(firstName, lastName);

        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже нанят");
        }

        if (employees.size() == staffSize) {
            throw new EmployeeStorageIsFullException("Штат заполнен");
        }

        employees.put(
                employeeKey,
                new Employee(firstName, lastName, salary, departmentId)
        );

        return employees.get(employeeKey);
    }
    @Override
    public void removeEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }

        employees.remove(employeeKey);
    }
    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }

        return employees.get(employeeKey);
    }
    @Override
    public Map<String, Employee> staff() {
        return employees;
    }
    @Override
    public Integer getMaxSalary(Integer departmentId) {
        return null;
    }
    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}
