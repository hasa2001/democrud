package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> thQuery = entityManager.createQuery("from Employee ", Employee.class);
        return thQuery.getResultList();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
