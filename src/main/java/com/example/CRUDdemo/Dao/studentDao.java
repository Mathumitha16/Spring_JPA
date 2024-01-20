package com.example.CRUDdemo.Dao;

import com.example.CRUDdemo.entity.Student;

import java.util.List;

public interface studentDao {
    public void save(Student theStudent);
    public Student findById(int id);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);

    public void update(Student theStudent);

    public void delete(int id);

    public int deleteByLastName(String lastName);




}
