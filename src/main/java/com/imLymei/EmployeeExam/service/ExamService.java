package com.imLymei.EmployeeExam.service;

import com.imLymei.EmployeeExam.model.Exam;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ExamService {
    public Exam saveExam(Exam exam);
    public List<Exam> getAllExams();
    public String deleteExams(int id);
}
