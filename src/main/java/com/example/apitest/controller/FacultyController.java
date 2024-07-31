package com.example.apitest.controller;

import com.example.apitest.model.Faculty;
import com.example.apitest.model.Student;
import com.example.apitest.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    @Autowired
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping("{id}")
    public Faculty getFaculty(@PathVariable Long id) {
        return facultyService.findFaculty(id);
    }

    @PostMapping
    public Faculty addFaculty(Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public void deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
    }

    @PutMapping
    public Faculty putFaculty(Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @GetMapping()
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

}
