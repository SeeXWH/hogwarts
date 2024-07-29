package com.example.apitest.service;

import com.example.apitest.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> studentLongMap = new HashMap<>();
    private long lastId = 0;

    public Student createStudent(Student student) {
        student.setId(++lastId);
        studentLongMap.put(student.getId(), student);
        return student;
    }

    public Student findStudent(long id) {
        return studentLongMap.get(id);
    }

    public Student editStudent(Student student) {
        studentLongMap.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id) {
        return studentLongMap.remove(id);
    }

    public Map<Long, Student> getAllStudent() {
        return studentLongMap;
    }


}
