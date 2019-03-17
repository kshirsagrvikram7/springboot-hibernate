package com.vksagar.springdata.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vksagar.springdata.product.entities.BankAccount;
import com.vksagar.springdata.product.repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository bankAccountRepository;
	
	@Override
	@Transactional
	public void transfer(int amount) {
		BankAccount bankAccountFrom = bankAccountRepository.findById(1).get();
		bankAccountFrom.setBal(bankAccountFrom.getBal()-amount);
		bankAccountRepository.save(bankAccountFrom);
		
		if(true)
			throw new RuntimeException();
		
		BankAccount bankAccountTo = bankAccountRepository.findById(2).get();
		bankAccountTo.setBal(bankAccountTo.getBal()+amount);
		bankAccountRepository.save(bankAccountTo);
	}

}
