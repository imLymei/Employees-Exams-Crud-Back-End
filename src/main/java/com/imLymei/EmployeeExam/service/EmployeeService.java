package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Employee;
import com.imLymei.EmployeeExam.model.Response;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public Response updateEmployee(int id, String newName);
    public List<Employee> getAllEmployees();
    public void deleteEmployee(int id);
}
