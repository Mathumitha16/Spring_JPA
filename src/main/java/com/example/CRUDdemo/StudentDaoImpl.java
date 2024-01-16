package com.example.CRUDdemo;

import com.example.CRUDdemo.entity.Student;
import com.example.CRUDdemo.studentDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements studentDao {

    private EntityManager entityManager;
    //Autowiring of Entity manager
    @Autowired
    public StudentDaoImpl(EntityManager em){
        this.entityManager=em;
    }
    //implementation of saving a java object
    @Override
    @Transactional
    public void save(Student theStudent){

        entityManager.persist(theStudent);


    }
    //implementation of finding by primary key
    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }
    //implementing quering all record from table
    @Override
    public List<Student> findAll(){
        TypedQuery<Student> query = entityManager.createQuery("FROM Student",Student.class);
        List<Student> result = query.getResultList();
        return result;

    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create Query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName =:data",Student.class) ;

        //set Query Parameters
        query.setParameter("data",lastName);
        List<Student> result = query.getResultList();
        return result;
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }
    @Override
    @Transactional
    public void delete(int id){
        Student theStudent = entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteByLastName(String lastName) {
        int query = entityManager.createQuery("DELETE FROM Student WHERE lastName=:lastName").setParameter("lastName",lastName).executeUpdate();
        return query;


    }

}
