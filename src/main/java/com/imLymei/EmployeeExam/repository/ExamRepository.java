package com.imLymei.EmployeeExam.repository;

import com.imLymei.EmployeeExam.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
