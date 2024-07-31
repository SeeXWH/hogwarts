package com.example.apitest;

import com.example.apitest.model.Faculty;
import com.example.apitest.repository.FacultyRepository;
import com.example.apitest.service.FacultyService;
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
public class FacultyServiceTest {

    @Mock
    private FacultyRepository facultyRepository;

    @InjectMocks
    private FacultyService facultyService;

    @Test
    void testCreateFaculty() {
        Faculty faculty = new Faculty("Test Faculty", "Green", 1);
        when(facultyRepository.save(faculty)).thenReturn(faculty);

        Faculty createdFaculty = facultyService.createFaculty(faculty);

        assertThat(createdFaculty).isEqualTo(faculty);
        verify(facultyRepository, times(1)).save(faculty);
    }

    @Test
    void testFindFaculty() {
        Faculty faculty = new Faculty("Test Faculty", "Green", 1);
        when(facultyRepository.findById(1L)).thenReturn(Optional.of(faculty));

        Faculty foundFaculty = facultyService.findFaculty(1L);

        assertThat(foundFaculty).isEqualTo(faculty);
        verify(facultyRepository, times(1)).findById(1L);
    }

    @Test
    void testEditFaculty() {
        Faculty faculty = new Faculty("Test Faculty", "Green", 1);
        when(facultyRepository.save(faculty)).thenReturn(faculty);

        Faculty editedFaculty = facultyService.editFaculty(faculty);

        assertThat(editedFaculty).isEqualTo(faculty);
        verify(facultyRepository, times(1)).save(faculty);
    }

    @Test
    void testDeleteFaculty() {
        facultyService.deleteFaculty(1L);
        verify(facultyRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAllFaculty() {
        List<Faculty> faculties = Arrays.asList(
                new Faculty("Test Faculty", "Green", 1),
                new Faculty("Test Faculty2", "Blue", 1)
        );
        when(facultyRepository.findAll()).thenReturn(faculties);

        List<Faculty> allFaculties = facultyService.getAllFaculty();

        assertThat(allFaculties).isEqualTo(faculties);
        verify(facultyRepository, times(1)).findAll();
    }
}
