package com.imLymei.EmployeeExam.repository;

import com.imLymei.EmployeeExam.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    long deleteByEmployeeId(int id);
    List<Registration> findAllByExamId(int id);
    List<Registration> findAllByExamIdAndEmployeeIdAndDate(int examId, int employeeId, Date date);
    List<Registration> findAllByDateBetween(Date startDate, Date finalDate);
}
