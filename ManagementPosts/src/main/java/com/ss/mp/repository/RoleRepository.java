package com.ss.mp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.mp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Role findById(Integer id);

}
