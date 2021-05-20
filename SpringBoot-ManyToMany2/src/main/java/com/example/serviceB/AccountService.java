package com.example.serviceB;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entityB.Account;
import com.example.repositoryB.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public Optional<Account> findOne(Integer id){
		return accountRepository.findById(id);
	}
	
	public Account create(Account account) {
		return accountRepository.save(account);
	}
	
	public List<Account> createAll(List<Account> accounts){
		return accountRepository.saveAll(accounts);
	}
}
