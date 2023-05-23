package com.Employee.Repository;
import java.util.*;
import com.Employee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


	@Query(value="select e.number,e.first_name,e.last_name,e.email,e.address_id,e.salary from emp e where e.number=:id and e.first_name=:name",nativeQuery = true)
	public Optional<Employee> findByIdAndName(int id,String name);

	@Query(value="select e.number,e.first_name,e.last_name,e.email,e.address_id,e.salary from emp e where e.first_name=:name",nativeQuery = true)
	public Optional<Employee>  findByFirstName(String name);

	@Query(value="select e.first_name,e.last_name from emp e order by first_name",nativeQuery = true)
	public List<Object> getByName();
}
