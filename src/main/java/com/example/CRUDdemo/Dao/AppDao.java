package com.example.CRUDdemo.Dao;

import com.example.CRUDdemo.entity.Instructor;
import com.example.CRUDdemo.entity.InstructorDetail;

public interface AppDao {
    public void saveInstructor(Instructor theInstructor);
    public Instructor findInstructorById(int id);

    public void deleteInstructor(int id);

    public InstructorDetail findInstructorDetail(int id);
}
