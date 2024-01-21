package com.example.CRUDdemo.DaoImplementations;

import com.example.CRUDdemo.Dao.AppDao;
import com.example.CRUDdemo.entity.Course;
import com.example.CRUDdemo.entity.Instructor;
import com.example.CRUDdemo.entity.InstructorDetail;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public Course findCourse(int id) {
        return em.find(Course.class,id);
    }

    @Override
    @Transactional
    public void addCourse(Course newCourse) {
        em.persist(newCourse);

    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        em.merge(course);

    }

    @Override
    public List<Course> getCoursesForInstructor(int InstructorId) {
        TypedQuery<Course> query = em.createQuery("FROM Course WHERE instructor.id=:InstructorId", Course.class);
        query.setParameter("InstructorId",InstructorId);
        List<Course> course = query.getResultList();
        return course;

    }

    @Override
    public Instructor findInstructorAndCourses(int id) {
        TypedQuery<Instructor> query = em.createQuery("SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id=:data",Instructor.class);
        query.setParameter("data",id);
        return query.getSingleResult();

    }


}
