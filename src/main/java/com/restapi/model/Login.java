package com.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Login
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int LoginID;
	
	private String Name;
	private String email;
	private String Password;
	
	public Login() 
	{
		
	}

	public int getLoginID() 
	{
		return LoginID;
	}

	public void setLoginID(int loginID) 
	{
		LoginID = loginID;
	}

	public String getName() 
	{
		return Name;
	}

	public void setName(String name)
	{
		Name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String Email)
	{
		email = Email;
	}

	public String getPassword()
	{
		return Password;
	}

	public void setPassword(String password)
	{
		Password = password;
	}
	
	
}
