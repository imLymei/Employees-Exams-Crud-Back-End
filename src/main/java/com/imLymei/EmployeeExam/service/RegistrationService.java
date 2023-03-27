package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Registration;

import java.util.Date;
import java.util.List;

public interface RegistrationService {
    public String saveRegistration(Registration registration);
    public List<Registration> getAllRegistrations();
    public long deleteByEmployeeId(int id);
    public void deleteRegistration(int id);
    public List<Registration> getAllBetween(Date startDate, Date finalDate);
}
