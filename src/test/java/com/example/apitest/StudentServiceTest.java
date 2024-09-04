package com.example.apitest;

import com.example.apitest.model.Student;
import com.example.apitest.repository.StudentRepository;
import com.example.apitest.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testCreateStudent() {
        Student student = new Student("John Doe", 52, 1);
        when(studentRepository.save(student)).thenReturn(student);

        Student createdStudent = studentService.createStudent(student);

        assertThat(createdStudent).isEqualTo(student);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void testFindStudent() {
        Student student = new Student("John Doe", 52, 1);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student foundStudent = studentService.findStudent(1L);

        assertThat(foundStudent).isEqualTo(student);
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void testEditStudent() {
        Student student = new Student("John Doe", 52, 1);
        when(studentRepository.save(student)).thenReturn(student);

        Student editedStudent = studentService.editStudent(student);

        assertThat(editedStudent).isEqualTo(student);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void testDeleteStudent() {
        studentService.deleteStudent(1L);
        verify(studentRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAllStudent() {
        List<Student> students = Arrays.asList(
                new Student("John Doe", 52, 1),
                new Student("John Doe", 52, 1)
        );
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> allStudents = studentService.getAllStudent();

        assertThat(allStudents).isEqualTo(students);
        verify(studentRepository, times(1)).findAll();
    }
}