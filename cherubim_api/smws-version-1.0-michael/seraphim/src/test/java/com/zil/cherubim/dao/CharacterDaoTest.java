package com.zil.cherubim.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.zil.cherubim.model.Character;
import com.zil.seraphim.test.impl.MasterTestImpl;

public class CharacterDaoTest extends MasterTestImpl{

	@Autowired
	CharacterDao characterDao;
	
	@Override
	public void doSetup() {
		Character character = new Character();

		character.setCharacterName("Character Abc");
		character.setGender("M");
		//character.setLevel(1);
		//character.set
		
		int isInserted = characterDao.createCharacter(character);
		assertThat(isInserted, is(not(0)));
	}
	
	@Test
	public void listAllCharacterTest() {
		List<Character> showAllCharacters = characterDao.getAllCharacters();
		assertThat(showAllCharacters, not(empty()));
	}
	
	@Test
	public void createCharacterTest(){
		Character character = new Character();

		character.setCharacterName("Character Abc2");
		character.setGender("M");
		//character.setLevel(1);
		//character.set
		
		int isInserted = characterDao.createCharacter(character);
		assertThat(isInserted, is(not(0)));
	}
	
	@Test
	public void updateCharacterTest(){
		List<Character> showAllCharacters = characterDao.getAllCharacters();
		assertThat(showAllCharacters, not(empty()));

		Character character = showAllCharacters.get(0);
		
		character.setLevel(5);
		character.setExperience(1000);
		character.setGold(1000);
		character.setHitpoints(50);
		character.setManapoints(100);
		character.setSkillpoints(2);
		character.setStatpoints(5);
		
		boolean isInserted = characterDao.updateCharacter(character);
		assertThat(isInserted, is(true));

		Character actualCharacter = characterDao.getCharacterInfo(character);
		assertThat(actualCharacter.getCharacterName(), is("Character Abc"));
		assertThat(actualCharacter.getLevel(), is(5));
	}
	
	@Test
	public void retrieveSingleCharacterTest(){
		List<Character> showAllCharacters = characterDao.getAllCharacters();
		assertThat(showAllCharacters, not(empty()));

		Character character = showAllCharacters.get(0);
		String expectedCharacterId = character.getCharacterName();
		
		Character actualCharacter = characterDao.getCharacterInfo(character);
		String actualCharacterId = actualCharacter.getCharacterName();
		assertThat(actualCharacterId, is(expectedCharacterId));
	}

	@Test
	public void deleteCharacterTest(){
		List<Character> showAllCharacters = characterDao.getAllCharacters();
		assertThat(showAllCharacters, not(empty()));

		Character character = showAllCharacters.get(0);
		boolean isInserted = characterDao.deleteCharacter(character);
		assertThat(isInserted, is(true));
		
		showAllCharacters = characterDao.getAllCharacters();
		assertThat(showAllCharacters, is(empty()));

	}
}
