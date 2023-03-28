package com.imLymei.EmployeeExam.controller;

import com.imLymei.EmployeeExam.model.Registration;
import com.imLymei.EmployeeExam.model.Response;
import com.imLymei.EmployeeExam.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/registration")
@CrossOrigin
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/add")
    public Response add(@RequestBody Registration registration){
        return registrationService.saveRegistration(registration);
    }

    @PutMapping("/update")
    public Response update(@RequestBody Registration registration){
        return registrationService.updateRegistration(registration);
    }

    @GetMapping("/getAll")
    public List<Registration> getAllRegistrations(){
        return registrationService.getAllRegistrations();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRegistration(@PathVariable int id){registrationService.deleteRegistration(id);}

    @GetMapping(value = "/getReport/{startDate}/{finalDate}")
    public List<Registration> getAllBetween(@PathVariable String startDate, @PathVariable String finalDate) throws ParseException {
        Date realStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date realFinalDate = new SimpleDateFormat("yyyy-MM-dd").parse(finalDate);
        return registrationService.getAllBetween(realStartDate,realFinalDate);
    }
}
