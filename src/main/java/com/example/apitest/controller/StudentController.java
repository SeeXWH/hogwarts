package com.example.apitest.controller;

import com.example.apitest.model.Student;
import com.example.apitest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.findStudent(id);
    }
    @PostMapping
    public Student addStudent(Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
    @PutMapping
    public Student putStudent(Student student){
        return studentService.editStudent(student);
    }

    @GetMapping()
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
}
