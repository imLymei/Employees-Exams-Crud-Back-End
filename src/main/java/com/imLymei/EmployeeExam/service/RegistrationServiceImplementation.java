package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Registration;
import com.imLymei.EmployeeExam.model.Response;
import com.imLymei.EmployeeExam.repository.EmployeeRepository;
import com.imLymei.EmployeeExam.repository.ExamRepository;
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

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Response saveRegistration(Registration registration) {
        List<Registration> amount = registrationRepository.findAllByExamIdAndEmployeeIdAndDate(registration.getExamId(),registration.getEmployeeId(),registration.getDate());
        Response response = new Response("error/Encontramos um registro semelhante");
        if (amount.size() == 0){
            if (examRepository.existsById(registration.getExamId())) {
                if (employeeRepository.existsById(registration.getEmployeeId())){
                    registrationRepository.save(registration);
                    response.setMessage("success/Novo registro adicionado");
                } else {
                    response.setMessage("error/Não encontramos nenhum funcionário com esse ID");
                }
            } else {
                response.setMessage("error/Não encontramos nenhum exame com esse ID");
            }
        }
        return response;
    }

    @Override
    public Response updateRegistration(Registration registration) {
        Response response = new Response("error/ID não encontrado");
        if (registrationRepository.existsById(registration.getId())) {
            if (registrationRepository.findAllByExamIdAndEmployeeIdAndDate(registration.getExamId(), registration.getEmployeeId(), registration.getDate()).isEmpty()){
                if (examRepository.existsById(registration.getExamId())){
                    if (employeeRepository.existsById(registration.getEmployeeId())){
                        Registration oldRegistration = registrationRepository.getReferenceById(registration.getId());
                        oldRegistration.setDate(registration.getDate());
                        oldRegistration.setEmployeeId(registration.getEmployeeId());
                        oldRegistration.setExamId(registration.getExamId());
                        response.setMessage("success/Registro Atualizado");
                    } else {
                        response.setMessage("error/Não encontramos nenhum funcionário com esse ID");
                    }
                } else {
                    response.setMessage("error/Não encontramos nenhum exame com esse ID");
                }
            } else {
                response.setMessage("error/Encontramos um registro semelhante");
            }
        }
        return  response;
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
    public void deleteRegistration(int id) {
        registrationRepository.deleteById(id);
    }

    @Override
    public List<Registration> getAllBetween(Date startDate, Date finalDate) {
        return registrationRepository.findAllByDateBetween(startDate,finalDate);
    }
}
