package com.cdac.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Player
{
	@Id
	private int PlayerID;
	
	private String PlayerName;
	private String PlayerDept;
	
	
	public Player() 
	{
		
	}


	public int getPlayerID() 
	{
		return PlayerID;
	}


	public void setPlayerID(int playerID)
	{
		PlayerID = playerID;
	}


	public String getPlayerName()
	{
		return PlayerName;
	}


	public void setPlayerName(String playerName)
	{
		PlayerName = playerName;
	}


	public String getPlayerDept()
	{
		return PlayerDept;
	}


	public void setPlayerDept(String playerDept) 
	{
		PlayerDept = playerDept;
	}
	
	
}
