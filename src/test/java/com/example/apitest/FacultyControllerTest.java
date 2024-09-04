package com.example.apitest;

import com.example.apitest.controller.FacultyController;
import com.example.apitest.model.Faculty;
import com.example.apitest.service.FacultyService;
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
public class FacultyControllerTest {

    @Mock
    private FacultyService facultyService;

    @InjectMocks
    private FacultyController facultyController;

    @Test
    void testGetFaculty() {
        Faculty faculty = new Faculty("Test Faculty", "Blue", 1L);
        when(facultyService.findFaculty(1L)).thenReturn(faculty);

        Faculty result = facultyController.getFaculty(1L);

        assertEquals(faculty, result);
        verify(facultyService, times(1)).findFaculty(1L);
    }

    @Test
    void testAddFaculty() {
        Faculty faculty = new Faculty("Test Faculty", "Blue", 1L);
        when(facultyService.createFaculty(faculty)).thenReturn(faculty);

        Faculty result = facultyController.addFaculty(faculty);

        assertEquals(faculty, result);
        verify(facultyService, times(1)).createFaculty(faculty);
    }

    @Test
    void testDeleteFaculty() {
        facultyController.deleteFaculty(1L);
        verify(facultyService, times(1)).deleteFaculty(1L);
    }

    @Test
    void testPutFaculty() {
        Faculty faculty = new Faculty("Test Faculty", "Blue", 1L);
        when(facultyService.editFaculty(faculty)).thenReturn(faculty);

        Faculty result = facultyController.putFaculty(faculty);

        assertEquals(faculty, result);
        verify(facultyService, times(1)).editFaculty(faculty);
    }

    @Test
    void testGetAllFaculty() {
        List<Faculty> faculties = Arrays.asList(
                new Faculty("Test Faculty 1", "Blue", 1L),
                new Faculty("Test Faculty 2", "Red", 2L)
        );
        when(facultyService.getAllFaculty()).thenReturn(faculties);

        List<Faculty> result = facultyController.getAllFaculty();

        assertEquals(faculties, result);
        verify(facultyService, times(1)).getAllFaculty();
    }
}