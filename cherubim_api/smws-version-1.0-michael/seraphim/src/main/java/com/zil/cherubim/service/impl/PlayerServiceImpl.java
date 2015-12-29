package com.zil.cherubim.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zil.cherubim.dao.PlayerDao;
import com.zil.cherubim.model.Player;
import com.zil.cherubim.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{
	public static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceImpl.class);

	@Autowired
	private PlayerDao playerDao;
	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.SUPPORTS)
	public List<Player> getAllPlayers() {
		return playerDao.getAllPlayers();
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.SUPPORTS)
	public Player getPlayerInfo(Player player) {
		return playerDao.getPlayerInfo(player);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean savePlayer(Player player, boolean isNew) {
		
		//Check first if it is a new player
		if(isNew){
			boolean isExistingPlayer=isPlayerExist(player);
			if(isExistingPlayer){
				LOGGER.error("player with name:{} and/or email:{} already exist!",player.getPlayerName(), player.getEmail());
				return false;
			}
			//save new player
			return playerDao.createPlayer(player);
		}
		//Update existing player		
		return playerDao.updatePlayer(player);
	}
	
	private boolean isPlayerExist(Player player){
		return playerDao.isPlayerExist(player);
	}

}
