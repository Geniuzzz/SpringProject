package com.springboot.springproject.service.impl;

import com.springboot.springproject.exception.ResourceNotFoundException;
import com.springboot.springproject.model.Employee;
import com.springboot.springproject.repository.EmployeeRepository;
import com.springboot.springproject.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long employeeId) {
        Employee employee1 = employeeRepository.findById(employeeId).orElseThrow( () -> new ResourceNotFoundException("Employee", "id", employeeId));
        employee1.setEmail(employee.getEmail());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        return employeeRepository.save(employee1);
    }
}
