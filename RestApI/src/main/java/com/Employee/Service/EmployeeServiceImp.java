package com.Employee.Service;

import com.Employee.Model.*;
import com.Employee.Repository.EmployeeRepository;

//import net.javaguides.springboot.Model.Employee;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService
{

	 @Autowired
	 private EmployeeRepository repository;
	 @Override
	 public List<Employee> getall()
	 {
		 return  repository.findAll();
	 }
	 @Override
	 public Employee getEmplEmpTrByid(int id)
	
	 {
			
			  Employee emp=null;
			  
			  Optional<Employee> optional=repository.findById(id); if(optional.isPresent())
			  { emp=optional.get(); } else { throw new RuntimeException("Invalid number");
			  }
			  
			  return emp;
			 
			/*
			 * int num=id.intValue(); Employee emp=repository.findById(id). orElseThrow(()->
			 * new ResourceNotFoundException("Employee not exiting in database :"+id));
			 * return ResponseEntity.ok(emp);
			 */
	 }
	 
	 @Override
	 public Employee update(Employee emp,int id)
	 {
		 Employee emp1=null;
		 
		 Optional<Employee> optional=repository.findById(id); 
		 if(optional.isPresent())
		  { emp1=optional.get(); 
		  } else 
		  {
			  throw new RuntimeException("Invalid number");
		  }
		 
		 emp1.setFirstname(emp.getFirstname());
		 emp1.setLastname(emp.getLastname());
		 emp1.setEmila(emp.getEmila());
		 emp1.setSalary(emp.getSalary());
		 
		 return repository.save(emp1);
		 
		 
	 }
	 @Override
	 public Employee findByIdAndName(int id,String name)
	 {
		 Employee emp=null;
		 Optional<Employee> optional=repository.findByIdAndName(id,name);
		 if(optional.isPresent())
		 {
			 emp=optional.get();
		 }
		 else
		 {
			 throw new RuntimeException("Invalid......!!");
		 }
		 return emp;
	 }
	 
	 @Override
	 public Employee create(Employee emp) {
		 return repository.save(emp);
	 }
	
}
