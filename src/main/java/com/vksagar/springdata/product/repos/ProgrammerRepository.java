package com.vksagar.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.vksagar.springdata.product.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
