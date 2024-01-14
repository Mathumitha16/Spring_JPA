package com.example.CRUDdemo;

import com.example.CRUDdemo.entity.Student;

public interface studentDao {
    public void save(Student theStudent);
    public Student findById(int id);


}
