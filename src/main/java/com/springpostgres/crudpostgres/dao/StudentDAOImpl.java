package com.springpostgres.crudpostgres.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springpostgres.crudpostgres.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entitymanager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class)
        .getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);
        // set query parameter
        theQuery.setParameter("theData", lastName);
        // execute query and get result list
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

}
