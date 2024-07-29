package com.example.apitest.model;

import jakarta.persistence.Entity;

import java.util.Objects;
@Entity
public class Student {
    private long id = 0L;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id +=1;
    }

    public Long getId() {
        return id;
    }

    public void setId(long   id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(id, student.id) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
