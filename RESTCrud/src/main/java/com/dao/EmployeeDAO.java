package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.Employee;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeDAO {
	 @PersistenceContext
	  private EntityManager entityManager;
	 
	 public void createEmployee(Employee emp){
	    entityManager.persist(emp);
	 }
	 
	 public List<Employee> getAllEmployee(){
        return entityManager.createQuery("select emp from Employee emp").getResultList();
	 }
	 
	/* public Employee getEmployeeById(String id){
	        return entityManager.find(Employee.class,id);
	 }*/
}
