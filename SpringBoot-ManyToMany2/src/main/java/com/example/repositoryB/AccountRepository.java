package com.example.repositoryB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entityB.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
