package com.imLymei.EmployeeExam.controller;

import com.imLymei.EmployeeExam.model.Exam;
import com.imLymei.EmployeeExam.service.ExamService;
import com.imLymei.EmployeeExam.service.ExamServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
@CrossOrigin
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/add")
    public String add(@RequestBody Exam exam){
        examService.saveExam(exam);
        return "Nem exam added";
    }

    @GetMapping("/getAll")
    public List<Exam> getAllExams(){return examService.getAllExams();}

    @DeleteMapping(value = "/delete/{id}")
    public String deleteExams(@PathVariable int id){return examService.deleteExams(id);}
}
