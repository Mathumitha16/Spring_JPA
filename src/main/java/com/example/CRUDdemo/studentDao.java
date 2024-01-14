package com.example.CRUDdemo;

import com.example.CRUDdemo.entity.Student;

import java.util.List;

public interface studentDao {
    public void save(Student theStudent);
    public Student findById(int id);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);

    public void update(Student theStudent);




}
