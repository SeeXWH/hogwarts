package com.example.apitest.service;

import com.example.apitest.model.Faculty;
import com.example.apitest.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty> facultyLongMap = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++lastId);
        facultyLongMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty findFaculty(long id){
        return facultyLongMap.get(id);
    }

    public Faculty editFaculty(Faculty faculty){
        facultyLongMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id){
        return facultyLongMap.remove(id);
    }
    public Map<Long, Faculty> getAllFaculty(){
        return facultyLongMap;
    }
}
