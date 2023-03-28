package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Exam;
import com.imLymei.EmployeeExam.model.Registration;
import com.imLymei.EmployeeExam.model.Response;
import com.imLymei.EmployeeExam.repository.ExamRepository;
import com.imLymei.EmployeeExam.repository.RegistrationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;
import java.util.Optional;

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
    public Response updateExam(Exam newExam) {
        Optional<Exam> foundList = examRepository.findById(newExam.getID());
        Response response = new Response("error/Id não encontrado");

        if(!foundList.isEmpty()) {
            Exam exam = examRepository.getReferenceById(newExam.getID());
            exam.setNAME(newExam.getNAME());
            response.setMessage("success/Exame Atualizado");
        }
        return response;
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public Response deleteExams(int id) {
        List<Registration> amount = registrationRepository.findAllByExamId(id);
        Response response = new Response("error/O exame possui registros salvos");
        if (amount.size() == 0){
            examRepository.deleteById(id);
            response.setMessage("success/Exame adicionado");
        }
        return response;
    }
}
