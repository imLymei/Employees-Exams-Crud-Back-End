package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Employee;
import com.imLymei.EmployeeExam.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RegistrationService registrationService;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        registrationService.deleteByEmployeeId(id);
    }
}
