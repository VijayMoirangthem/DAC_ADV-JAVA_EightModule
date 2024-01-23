package com.cdac.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.rest.model.Player;
import com.cdac.rest.repository.PlayerRepository;



@Service
@Transactional
public class PlayerService 
{
	@Autowired
	PlayerRepository PRepo;
	
	public List<Player> getPlayer()
	{
		return PRepo.findAll();
	}
	
	public Player getPlayerByID(int PlayerID)
	{
		return PRepo.findById(PlayerID).get();
	}
	
	public void insertPlayer(Player P)
	{
		PRepo.save(P);
	}
	
	public void deletePlayer(int PlayerID)
	{
		PRepo.deleteById(PlayerID);
	}
	
	public void updateStudent(Player P)
	{
		PRepo.save(P);
	}
}
