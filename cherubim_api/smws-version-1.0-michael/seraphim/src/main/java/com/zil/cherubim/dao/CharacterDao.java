package com.zil.cherubim.dao;

import java.util.List;
import com.zil.cherubim.model.Character;
public interface CharacterDao {
	public List<Character> getAllCharacters();
	public Character getCharacterInfo(Character character);
	public boolean saveCharacter(Character character); //save newly created or updated character info
	public boolean deleteCharacter(Character character); //delete character

}
