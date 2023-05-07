package com.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.Model.Address;
public interface AddressRepo extends JpaRepository<Address, Integer>{

}
