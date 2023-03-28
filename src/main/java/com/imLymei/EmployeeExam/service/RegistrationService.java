package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Registration;
import com.imLymei.EmployeeExam.model.Response;

import java.util.Date;
import java.util.List;

public interface RegistrationService {
    public Response saveRegistration(Registration registration);
    public Response updateRegistration(Registration registration);
    public List<Registration> getAllRegistrations();
    public long deleteByEmployeeId(int id);
    public void deleteRegistration(int id);
    public List<Registration> getAllBetween(Date startDate, Date finalDate);
}
