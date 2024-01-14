package com.example.CRUDdemo;

import com.example.CRUDdemo.entity.Student;
import com.example.CRUDdemo.studentDao;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements studentDao {
    private EntityManager entityManager;
    @Autowired
    public StudentDaoImpl(EntityManager em){
        this.entityManager=em;
    }
    @Override
    @Transactional
    public void save(Student theStudent){

        entityManager.persist(theStudent);


    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

}
