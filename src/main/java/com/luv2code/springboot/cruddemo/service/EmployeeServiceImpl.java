package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.dao.EmployeeDAOJpaImpl;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAOJpa;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAOJpaImpl employeeDAOJpa) {
        this.employeeDAOJpa = employeeDAOJpa;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAOJpa.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeDAOJpa.findEmployeeById(id);
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAOJpa.saveEmployee(employee);
    }

    @Transactional
    @Override
    public void deleteEmployeeById(int id) {
        employeeDAOJpa.deleteEmployeeById(id);
    }
}
