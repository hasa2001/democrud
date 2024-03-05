package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findEmployeeById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
