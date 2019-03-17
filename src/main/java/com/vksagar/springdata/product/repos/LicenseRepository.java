package com.vksagar.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.vksagar.springdata.product.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
