package com.cdac.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.rest.model.Player;

public interface PlayerRepository extends JpaRepository<Player,Integer>
{
	 
}
