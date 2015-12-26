package com.zil.cherubim.dao;

import java.util.List;

import com.zil.cherubim.model.Player;

public interface PlayerDao {
	public List<Player> getAllPlayers();
	public Player getPlayerInfo(Player player);
	public boolean savePlayer(Player player); //save newly created or updated character info
}
