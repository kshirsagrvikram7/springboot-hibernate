package com.vksagar.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.vksagar.springdata.product.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
