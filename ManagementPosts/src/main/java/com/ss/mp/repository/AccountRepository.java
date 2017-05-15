package com.ss.mp.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.querydsl.core.types.Predicate;
import com.ss.mp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>, QueryDslPredicateExecutor<Account>{
	
	@Query("select u from Account u where u.userName=:loginId")
	public Optional<Account> findByLoginId(@Param("loginId") String loginId);
	
	public Page<Account> findAll(Predicate where, Pageable pageRequest);
	
	public Account findByUserName(String userName);

}
