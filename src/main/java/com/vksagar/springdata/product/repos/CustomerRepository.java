package com.vksagar.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.vksagar.springdata.product.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
