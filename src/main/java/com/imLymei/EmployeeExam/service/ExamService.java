package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Exam;
import com.imLymei.EmployeeExam.model.Response;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ExamService {
    public Exam saveExam(Exam exam);
    public Response updateExam(Exam newExam);
    public List<Exam> getAllExams();
    public Response deleteExams(int id);
}
