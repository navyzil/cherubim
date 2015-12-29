package com.zil.cherubim.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zil.cherubim.dao.PlayerDao;
import com.zil.cherubim.model.Player;
import com.zil.seraphim.test.impl.MasterTestImpl;

public class PlayerDaoTest extends MasterTestImpl{

	@Autowired
	PlayerDao playerDao;
	
	@Override
	public void doSetup() {
		Player player = new Player();
		//player.setPlayerId(1);
		player.setPlayerName("Player Name 123");
		player.setEmail("uniqueEmail@email.com");
		player.setPassword("Password@123");
		player.setBirthdate(new Date());
		boolean isInserted = playerDao.createPlayer(player);
		assertThat(isInserted, is(true));
	}
	
	@Test
	public void listAllPlayerTest() {
		List<Player> allPlayers = playerDao.getAllPlayers();
		assertThat(allPlayers, not(empty()));
	}
	
	@Test
	public void createPlayerTest(){
		Player player = new Player();
//		player.setPlayerId(2);
		player.setPlayerName("Player Name 1232");
		player.setEmail("uniqueEmail2@email.com");
		player.setPassword("Password@123");
		player.setBirthdate(new Date());
		boolean isInserted = playerDao.createPlayer(player);
		assertThat(isInserted, is(true));
	}
	
	@Test
	public void updatePlayerTest(){
		List<Player> allPlayers = playerDao.getAllPlayers();
		assertThat(allPlayers, not(empty()));

		Player player = allPlayers.get(0);	
//		player.setPlayerId(2);
		player.setPlayerName("Player Name 12");
		//player.setEmail("uniqueEmail2@email.com");
		player.setPassword("Password@1243Edited");
		//player.setBirthdate(new Date());
		
		boolean isInserted = playerDao.updatePlayer(player);
		assertThat(isInserted, is(true));

		Player actualPlayer = playerDao.getPlayerInfo(player);
		assertThat(actualPlayer.getPlayerId(), is(1));
		assertThat(actualPlayer.getEmail(), is("uniqueEmail@email.com"));
		assertThat(actualPlayer.getPassword(),is("Password@1243Edited"));
		assertThat(actualPlayer.getPlayerName(),is("Player Name 12"));

	}
	
	@Test
	public void retrieveSinglePlayerTest(){
		List<Player> allPlayers = playerDao.getAllPlayers();
		assertThat(allPlayers, not(empty()));

		Player player = allPlayers.get(0);
		int expectedPlayerId = player.getPlayerId();
		
		Player actualPlayer = playerDao.getPlayerInfo(player);
		int actualPlayerId = actualPlayer.getPlayerId();
		assertThat(actualPlayerId, is(expectedPlayerId));
	}
	
	@Test
	public void checkIfPlayerExistTest(){
		Player player = new Player();
//		player.setPlayerId(1);
		player.setPlayerName("Player Name 123");
		player.setEmail("uniqueEmail@email.com");
		player.setPassword("Password@123");
		player.setBirthdate(new Date());
		
		boolean playerExist = playerDao.isPlayerExist(player);
		
		assertThat(playerExist, is(true));
		
		//if player don't exist
		
		player = new Player();
//		player.setPlayerId(2);
		player.setPlayerName("Player Name 1234");
		player.setEmail("uniqueEmail2@email.com");
		player.setPassword("Password@123");
		player.setBirthdate(new Date());
		
		playerExist = playerDao.isPlayerExist(player);
		assertThat(playerExist, is(false));

	}
}
