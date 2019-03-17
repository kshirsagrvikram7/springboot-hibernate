package com.vksagar.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.vksagar.springdata.product.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
