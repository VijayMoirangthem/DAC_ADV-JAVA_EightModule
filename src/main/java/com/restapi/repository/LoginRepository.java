package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.model.Login;

public interface LoginRepository extends JpaRepository<Login,Integer> 
{
	public Login findByEmail(String email);
}
