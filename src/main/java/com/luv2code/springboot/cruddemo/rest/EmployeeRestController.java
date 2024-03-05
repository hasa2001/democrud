package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();

    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findEmployeeById(employeeId);
       if (employee==null){
           throw new RuntimeException("employee id not found - "+employeeId);
       }
        return employee;

    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        employee.setId(0);
       return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
       return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
      Employee employee=  employeeService.findEmployeeById(employeeId);
      if (employee==null){
          throw  new RuntimeException("Employee id not found - "+employeeId);
      }
      employeeService.deleteEmployeeById(employeeId);
      return "Deleted employee id - "+employeeId;
    }
}
