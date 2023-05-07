package com.Employee.Service;

import com.Employee.Model.Employee;
import java.util.*;
public interface EmployeeService {

   List<Employee>  getall();
   Employee getEmplEmpTrByid(int id);
   Employee update(Employee emp,int id);
   Employee findByIdAndName(int id,String name);
   Employee create(Employee emp);
}
