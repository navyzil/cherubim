package com.zil.cherubim.service;

import java.util.List;

import com.zil.cherubim.model.Player;

public interface PlayerService {
	public List<Player> getAllPlayers();
	public Player getPlayerInfo(Player player);
	public boolean savePlayer(Player player, boolean isNew); //save newly created or updates exsiting character info
	
}
