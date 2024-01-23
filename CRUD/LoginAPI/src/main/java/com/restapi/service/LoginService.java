package com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restapi.model.Login;
import com.restapi.repository.LoginRepository;

@Service
@Transactional
public class LoginService 
{
	@Autowired
	LoginRepository LRepo;
	
	public void addUser(Login L)
	{
		LRepo.save(L);
	}
	
	public List<Login> getLogin()
	{
		return LRepo.findAll();
	}
	
	public Login getByEmail(String email)
	{
		return LRepo.findByEmail(email);
	}
}
