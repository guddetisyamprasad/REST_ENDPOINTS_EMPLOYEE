package com.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import com.Employee.Service.*;
import java.util.*;
import com.Employee.*;
import com.Employee.Model.Employee;

import net.bytebuddy.matcher.ModifierMatcher.Mode;
@RestController

public class EmployeeController {
	@Autowired
	 private EmployeeService empservice; 
	@GetMapping("/GetAll")
	public List<Employee> allemp()
	{
		
		return empservice.getall();
		
	}
	//added by syam
	@GetMapping("/GetAllId/{id}")
	public Employee allempid(@PathVariable int id)
	{
		
		return empservice.getEmplEmpTrByid(id);
		
		
	}
	@PutMapping("/updateemp/{id}")
	public ResponseEntity<Employee> update(@PathVariable("id") int num,@RequestBody Employee emp)
	{
		
		return new ResponseEntity<Employee>(empservice.update(emp, num),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee> create(@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(empservice.create(emp),HttpStatus.OK);
	}
	
	@GetMapping("id/name/{id}/{name}")
	public Employee findIdAndName(@PathVariable int id,@PathVariable String name)
	{
		return empservice.findByIdAndName(id, name);
	}
	//Find by Name
	@GetMapping("getInfoByName/{name}")
	public Employee findName(@PathVariable String name)
	{
		return empservice.findByName(name);
	}
}
