package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Exam;
import com.imLymei.EmployeeExam.model.Registration;
import com.imLymei.EmployeeExam.repository.ExamRepository;
import com.imLymei.EmployeeExam.repository.RegistrationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;

@Service
@Transactional
public class ExamServiceImplementation implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public String deleteExams(int id) {
        List<Registration> amount = registrationRepository.findAllByExamId(id);
        if (amount.size() == 0){
            examRepository.deleteById(id);
            return "Exam deleted";
        }
        return "Exam has registrations";
    }
}
