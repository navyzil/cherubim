package com.zil.cherubim.dao;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zil.cherubim.model.Character;
import com.zil.cherubim.model.Player;
import com.zil.cherubim.model.PlayerCharacter;
import com.zil.seraphim.test.impl.MasterTestImpl;

public class PlayerCharacterDaoTest extends MasterTestImpl {

	@Autowired
	PlayerDao playerDao;
	
	@Autowired
	CharacterDao characterDao;
	
	@Autowired
	PlayerCharacterDao playerCharacterDao;
	
	@Override
	public void doSetup() {
		//Create a player
		Player player = new Player();
		player.setPlayerId(1);
		player.setPlayerName("Player Name 123");
		player.setEmail("uniqueEmail@email.com");
		player.setPassword("Password@123");
		player.setBirthdate(new Date());
		
		boolean isPlayerCreated = playerDao.createPlayer(player);
		assertThat(isPlayerCreated, is(true));


	}

	@Test
	public void playerCreatedCharacterTest(){
		//get the player
		List<Player> allPlayers = playerDao.getAllPlayers();
		assertThat(allPlayers, not(empty()));

		Player player = allPlayers.get(0);
		int playerId = player.getPlayerId();
		
		//the player creates a character
		Character character = new Character();
		character.setCharacterName("Character Abc");
		character.setGender("M");
		
		int characterId = characterDao.createCharacter(character);
		assertThat(characterId, is(not(0)));
		
		PlayerCharacter playerCharacter = new PlayerCharacter();
		playerCharacter.setPlayerId(playerId);
		playerCharacter.setCharacterId(characterId);
		
		boolean isSaved = playerCharacterDao.savePlayerCharacter(playerCharacter);
		assertThat(isSaved, is(true));
	}
	
	@Test
	public void playersCharactersTest(){
		//get the player
		List<Player> allPlayers = playerDao.getAllPlayers();
		assertThat(allPlayers, not(empty()));

		Player player = allPlayers.get(0);
		int playerId = player.getPlayerId();
		
		//the player creates a character
		Character character = new Character();
		character.setCharacterName("Character Abc1");
		character.setGender("M");
		
		int characterId = characterDao.createCharacter(character);
		assertThat(characterId, is(not(0)));
		
		PlayerCharacter playerCharacter = new PlayerCharacter();
		playerCharacter.setPlayerId(playerId);
		playerCharacter.setCharacterId(characterId);
		
		boolean isSaved = playerCharacterDao.savePlayerCharacter(playerCharacter);
		assertThat(isSaved, is(true));
		
		//the player creates a character2

		character = new Character();
		character.setCharacterName("Character Abc2");
		character.setGender("M");
		
		characterId = characterDao.createCharacter(character);
		assertThat(characterId, is(not(0)));
		
		playerCharacter = new PlayerCharacter();
		playerCharacter.setPlayerId(playerId);
		playerCharacter.setCharacterId(characterId);
		
		isSaved = playerCharacterDao.savePlayerCharacter(playerCharacter);
		assertThat(isSaved, is(true));
		
		//the player creates a character3

		character = new Character();
		character.setCharacterName("Character Abc2");
		character.setGender("M");
		
		characterId = characterDao.createCharacter(character);
		assertThat(characterId, is(not(0)));
		
		playerCharacter = new PlayerCharacter();
		playerCharacter.setPlayerId(playerId);
		playerCharacter.setCharacterId(characterId);
		
		isSaved = playerCharacterDao.savePlayerCharacter(playerCharacter);
		assertThat(isSaved, is(true));
		
		
		//retrieve all the characters of the player
		List<PlayerCharacter> allPlayersCharacters = playerCharacterDao.getAllPlayersCharacters(player);
		int numberOfCharacters = allPlayersCharacters.size();
		assertThat(numberOfCharacters, is(3));
	}
	
	@Test
	public void playerDeleteCharactersTest(){
		//get the player
		List<Player> allPlayers = playerDao.getAllPlayers();
		assertThat(allPlayers, not(empty()));

		Player player = allPlayers.get(0);
		int playerId = player.getPlayerId();
		
		//the player creates a character
		Character character = new Character();
		character.setCharacterName("Character Abc1");
		character.setGender("M");
		
		int characterId = characterDao.createCharacter(character);
		assertThat(characterId, is(not(0)));
		
		PlayerCharacter playerCharacter = new PlayerCharacter();
		playerCharacter.setPlayerId(playerId);
		playerCharacter.setCharacterId(characterId);
		
		boolean isSaved = playerCharacterDao.savePlayerCharacter(playerCharacter);
		assertThat(isSaved, is(true));
		
		//the player creates a character2

		character = new Character();
		character.setCharacterName("Character Abc2");
		character.setGender("M");
		
		characterId = characterDao.createCharacter(character);
		assertThat(characterId, is(not(0)));
		
		playerCharacter = new PlayerCharacter();
		playerCharacter.setPlayerId(playerId);
		playerCharacter.setCharacterId(characterId);
		
		isSaved = playerCharacterDao.savePlayerCharacter(playerCharacter);
		assertThat(isSaved, is(true));
		
		//the player creates a character3

		character = new Character();
		character.setCharacterName("Character Abc2");
		character.setGender("M");
		
		characterId = characterDao.createCharacter(character);
		assertThat(characterId, is(not(0)));
		
		playerCharacter = new PlayerCharacter();
		playerCharacter.setPlayerId(playerId);
		playerCharacter.setCharacterId(characterId);
		
		isSaved = playerCharacterDao.savePlayerCharacter(playerCharacter);
		assertThat(isSaved, is(true));
		
		
		//retrieve all the characters of the player
		List<PlayerCharacter> allPlayersCharacters = playerCharacterDao.getAllPlayersCharacters(player);
		int numberOfCharacters = allPlayersCharacters.size();
		assertThat(numberOfCharacters, is(3));
		
		//delete one of the player characters mappers
		boolean isDeleted = playerCharacterDao.deletePlayerCharacter(playerCharacter);
		assertThat(isDeleted, is(true));
		
		allPlayersCharacters = playerCharacterDao.getAllPlayersCharacters(player);
		int newNumberOfCharacters = allPlayersCharacters.size();
		assertThat(newNumberOfCharacters, lessThan(numberOfCharacters));
	}
}
