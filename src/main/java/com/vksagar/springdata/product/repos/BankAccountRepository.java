package com.vksagar.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.vksagar.springdata.product.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
