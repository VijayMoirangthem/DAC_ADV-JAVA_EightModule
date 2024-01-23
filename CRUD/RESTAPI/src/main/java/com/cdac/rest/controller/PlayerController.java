package com.cdac.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.rest.model.Player;
import com.cdac.rest.service.PlayerService;

@RestController
@RequestMapping("/api/player")
public class PlayerController
{
	@Autowired
	PlayerService PServ;
	
	@GetMapping("/")
	public List<Player> getPlayer()
	{
		List<Player> PlayerList = PServ.getPlayer();
		return PlayerList;
	}
	
	@GetMapping("/{id}")
	public Player getPlayer(@PathVariable int id)
	{
		Player player = PServ.getPlayerByID(id);
		return player;
	}
	
	@PostMapping("/")
	public void insertPlayer(@RequestBody Player P)
	{
		PServ.insertPlayer(P);
	}
	
	@DeleteMapping("/{id}")
	public void deletePlayer(@PathVariable int id)
	{
		PServ.deletePlayer(id);
	}
	
	@PutMapping("/")
	public void updatePlayer(@RequestBody Player P)
	{
		PServ.updateStudent(P);
	}
}
