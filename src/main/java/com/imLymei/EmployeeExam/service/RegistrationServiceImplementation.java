package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Registration;
import com.imLymei.EmployeeExam.repository.RegistrationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RegistrationServiceImplementation implements RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public String saveRegistration(Registration registration) {
        List<Registration> amount = registrationRepository.findAllByExamIdAndEmployeeIdAndDate(registration.getExamId(),registration.getEmployeeId(),registration.getDate());
        if (amount.size() == 0){
            registrationRepository.save(registration);
            return "New exam added";
        }
        return ("We found another exam like that");
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    @Override
    public long deleteByEmployeeId(int id) {
        return registrationRepository.deleteByEmployeeId(id);
    }

    @Override
    public List<Registration> getAllBetween(Date startDate, Date finalDate) {
        return registrationRepository.findAllByDateBetween(startDate,finalDate);
    }
}
