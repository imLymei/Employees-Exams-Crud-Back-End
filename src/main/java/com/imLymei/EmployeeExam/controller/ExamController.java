package com.imLymei.EmployeeExam.controller;

import com.imLymei.EmployeeExam.model.Exam;
import com.imLymei.EmployeeExam.model.Response;
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
    public Response add(@RequestBody Exam exam){
        examService.saveExam(exam);
        Response response = new Response("success/Nem exam added");
        return response;
    }

    @PutMapping("/update")
    public Response update(@RequestBody Exam exam){
        return examService.updateExam(exam);
    }

    @GetMapping("/getAll")
    public List<Exam> getAllExams(){return examService.getAllExams();}

    @DeleteMapping(value = "/delete/{id}")
    public Response deleteExams(@PathVariable int id){return examService.deleteExams(id);}
}
