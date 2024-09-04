package com.example.apitest;

import com.example.apitest.controller.StudentController;
import com.example.apitest.model.Student;
import com.example.apitest.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void testGetStudent() {
        Student student = new Student("Test Student", 20, 1L);
        when(studentService.findStudent(1L)).thenReturn(student);

        Student result = studentController.getStudent(1L);

        assertEquals(student, result);
        verify(studentService, times(1)).findStudent(1L);
    }

    @Test
    void testAddStudent() {
        Student student = new Student("Test Student", 20, 1L);
        when(studentService.createStudent(student)).thenReturn(student);

        Student result = studentController.addStudent(student);

        assertEquals(student, result);
        verify(studentService, times(1)).createStudent(student);
    }

    @Test
    void testDeleteStudent() {
        studentController.deleteStudent(1L);
        verify(studentService, times(1)).deleteStudent(1L);
    }

    @Test
    void testPutStudent() {
        Student student = new Student("Test Student", 20, 1L);
        when(studentService.editStudent(student)).thenReturn(student);

        Student result = studentController.putStudent(student);

        assertEquals(student, result);
        verify(studentService, times(1)).editStudent(student);
    }

    @Test
    void testGetAllStudent() {
        List<Student> students = Arrays.asList(
                new Student("Test Student 1", 20, 1L),
                new Student("Test Student 2", 22, 2L)
        );
        when(studentService.getAllStudent()).thenReturn(students);

        List<Student> result = studentController.getAllStudent();

        assertEquals(students, result);
        verify(studentService, times(1)).getAllStudent();
    }
}