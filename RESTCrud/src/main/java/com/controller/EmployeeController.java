package com.controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EmployeeDAO;
import com.model.Employee;

@RestController
@Path("/myresource")
public class EmployeeController {

	@Autowired
    private EmployeeDAO empDao;
	
	 @RequestMapping(value="/create", method=RequestMethod.POST, 
	           produces="application/json", consumes="application/json")
	    public void createEmployee(@RequestBody Employee emp)
	    {
	        empDao.createEmployee(emp);
	    }
	 	@Path("/employees")
	    @RequestMapping(value="/employees",produces="application/json",
	            method=RequestMethod.GET)
	    public List getAllEmployee()
	    {
	        List employeeList = empDao.getAllEmployee();
	        return employeeList;
	    }
	
}
