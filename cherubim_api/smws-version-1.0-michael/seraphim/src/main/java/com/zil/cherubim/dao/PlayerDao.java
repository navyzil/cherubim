package com.zil.cherubim.dao;

import java.util.List;

import com.zil.cherubim.model.Player;

public interface PlayerDao {
	public List<Player> getAllPlayers();
	public Player getPlayerInfo(Player player);
	public boolean createPlayer(Player player); //save newly created character info
	public boolean updatePlayer(Player player); //save updated character info
	public boolean isPlayerExist(Player player);
}
