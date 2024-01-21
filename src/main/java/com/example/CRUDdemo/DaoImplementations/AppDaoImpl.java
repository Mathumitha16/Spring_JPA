package com.example.CRUDdemo.DaoImplementations;

import com.example.CRUDdemo.Dao.AppDao;
import com.example.CRUDdemo.entity.Instructor;
import com.example.CRUDdemo.entity.InstructorDetail;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDaoImpl implements AppDao {
    private EntityManager em;
    @Autowired
    public AppDaoImpl(EntityManager em){
        this.em=em;
    }
    @Override
    @Transactional
    public void saveInstructor(Instructor theInstructor) {
        em.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int id) {
        return(em.find(Instructor.class,id));
    }

    @Override
    @Transactional
    public void deleteInstructor(int id) {
        Instructor instructor = em.find(Instructor.class,id);
        em.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetail(int id) {
        return em.find(InstructorDetail.class,id);
    }

}
