package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Employee;
import com.imLymei.EmployeeExam.model.Response;
import com.imLymei.EmployeeExam.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Response updateEmployee(int id, String newName) {
        Optional<Employee> amount = employeeRepository.findById(id);
        Response response = new Response("error/ID não encontrado");
        if (!amount.isEmpty()){
            Employee employee = employeeRepository.getReferenceById(id);
            employee.setName(newName);
            response.setMessage("success/Funcionário atualizado");
        }
        return response;
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
