package com.imLymei.EmployeeExam.controller;

import com.imLymei.EmployeeExam.model.Employee;
import com.imLymei.EmployeeExam.model.Response;
import com.imLymei.EmployeeExam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String add(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return "New employee added";
    }

    @PutMapping("/update")
    public Response update(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee.getId(),employee.getName());
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees(){return employeeService.getAllEmployees();}

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "Employee deleted";
    }
}
