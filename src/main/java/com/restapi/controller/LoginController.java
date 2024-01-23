package com.restapi.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.Login;
import com.restapi.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/login")
public class LoginController 
{
	@Autowired
	LoginService LServ;
	
	@GetMapping
	public List<Login> getLogin()
	{
		List<Login> LList = LServ.getLogin();
		return LList;
	}
	
	private String encryptPass(String pass)
	{
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = pass;
		String encodedString = encoder.encodeToString(
	    normalString.getBytes(StandardCharsets.UTF_8) );
		return encodedString;
	}
	
	@PostMapping("/adduser")
	public void addUser(@RequestBody Login L)
	{
		String Pass = L.getPassword();
		String Pass2 = encryptPass(Pass);
		L.setPassword(Pass2);
		LServ.addUser(L);
	}
	
	@GetMapping("/login")
	public String loginUser(HttpServletRequest req , @RequestBody Login L)
	{
		String email = L.getEmail();
		String pass = L.getPassword();
		String pass2 = encryptPass(pass);
		
		Login USER = LServ.getByEmail(email);
		
		if(USER == null)
		{
			return "User Does not Exist";
		}
		
		else if((USER.getEmail().equals(email)) && (USER.getPassword().equals(pass2)))
		{
			req.getSession().setAttribute("user", USER.getName());
			return "Login Successful";
		}
		
		return "Wrong ID or Password";
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest req)
	{
		req.getSession().removeAttribute("user");
		req.getSession().invalidate();
		return "Logout Successful";
	}
}
