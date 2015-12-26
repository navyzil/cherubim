package com.zil.cherubim.dao;

import java.util.List;

import com.zil.cherubim.model.Player;
import com.zil.cherubim.model.PlayerCharacter;
public interface PlayerCharacterDao {
	public List<PlayerCharacter> getAllPlayersCharacters(Player player);
	public boolean savePlayerCharacter(PlayerCharacter playerCharacter);
}
