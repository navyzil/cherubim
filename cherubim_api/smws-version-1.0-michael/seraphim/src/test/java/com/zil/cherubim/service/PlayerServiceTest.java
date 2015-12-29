package com.zil.cherubim.service;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zil.cherubim.model.Player;
import com.zil.seraphim.test.impl.MasterTestImpl;

public class PlayerServiceTest extends MasterTestImpl {
	
	@Autowired
	PlayerService playerService;
	
	@Override
	public void doSetup() {
		Player player = new Player();
//		player.setPlayerId(1);
		player.setPlayerName("Player Name 123");
		player.setEmail("uniqueEmail@email.com");
		player.setPassword("Password@123");
		player.setBirthdate(new Date());
		
		Boolean isNewPlayer = true;
		boolean isInserted = playerService.savePlayer(player, isNewPlayer);
		assertThat(isInserted, is(true));
	}
	
	@Test
	public void listAllPlayerTest() {
		List<Player> allPlayers = playerService.getAllPlayers();
		assertThat(allPlayers, not(empty()));
	}

	@Test
	public void retrieveSinglePlayerTest(){
		List<Player> allPlayers = playerService.getAllPlayers();
		assertThat(allPlayers, not(empty()));

		Player player = allPlayers.get(0);
		int expectedPlayerId = player.getPlayerId();
		
		Player actualPlayer = playerService.getPlayerInfo(player);
		int actualPlayerId = actualPlayer.getPlayerId();
		assertThat(actualPlayerId, is(expectedPlayerId));
	}

	@Test
	public void createNewPlayerTest(){
		Player player = new Player();
//		player.setPlayerId(2);
		player.setPlayerName("Player Name 1232");
		player.setEmail("uniqueEmail2@email.com");
		player.setPassword("Password@123");
		player.setBirthdate(new Date());
		
		Boolean isNewPlayer = true;
		boolean isInserted = playerService.savePlayer(player, isNewPlayer);
		assertThat(isInserted, is(true));
	}

	@Test
	public void createExistingPlayerTest(){
		Player player = new Player();
//		player.setPlayerId(3);
		player.setPlayerName("Player Name 123");
		player.setEmail("uniqueEmail@email.com");
		player.setPassword("Password@123");
		player.setBirthdate(new Date());
		
		Boolean isNewPlayer = true;
		boolean isInserted = playerService.savePlayer(player, isNewPlayer);
		assertThat(isInserted, is(false));
	}
	
	@Test
	public void updateExistingPlayerTest(){
		List<Player> allPlayers = playerService.getAllPlayers();
		assertThat(allPlayers, not(empty()));

		Player player = allPlayers.get(0);	
//		player.setPlayerId(2);
		player.setPlayerName("Player Name 12");
		//player.setEmail("uniqueEmail2@email.com");
		player.setPassword("Password@1243Edited");
		
		Boolean isNewPlayer = false;
		boolean isUpdated = playerService.savePlayer(player, isNewPlayer);
		assertThat(isUpdated, is(true));
	}


}
