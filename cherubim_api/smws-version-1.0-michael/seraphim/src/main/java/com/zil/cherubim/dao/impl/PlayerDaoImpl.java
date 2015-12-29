package com.zil.cherubim.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zil.cherubim.dao.PlayerDao;
import com.zil.cherubim.mapper.PlayerMapper;
import com.zil.cherubim.model.Player;
import com.zil.cherubim.model.PlayerExample;
import com.zil.cherubim.model.PlayerExample.Criteria;

@Repository
public class PlayerDaoImpl implements PlayerDao {
	public static final Logger LOGGER = LoggerFactory.getLogger(PlayerDaoImpl.class);
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public List<Player> getAllPlayers() {
		PlayerExample example = new PlayerExample();
		PlayerMapper playerMapper = sessionFactory.openSession().getMapper(PlayerMapper.class);
		
		return playerMapper.selectByExample(example);
	}

	@Override
	public Player getPlayerInfo(Player player) {
		PlayerMapper playerMapper = sessionFactory.openSession().getMapper(PlayerMapper.class);
		playerMapper = sessionFactory.openSession().getMapper(PlayerMapper.class);
		
		return playerMapper.selectByPrimaryKey(player.getId());
	}

	@Override
	public boolean createPlayer(Player player) {
		
		PlayerMapper playerMapper = sessionFactory.openSession().getMapper(PlayerMapper.class);
		//generate new playerId based on the last inserted playerId

		LOGGER.info("Generating playerId...");
		int playerId = generatePlayerId();
		player.setPlayerId(playerId);

		int result = playerMapper.insertSelective(player);
		if(result == 1){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updatePlayer(Player player) {
		PlayerMapper playerMapper = sessionFactory.openSession().getMapper(PlayerMapper.class);
		int result = playerMapper.updateByPrimaryKeySelective(player);
		if(result == 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean isPlayerExist(Player player) {
		PlayerMapper playerMapper = sessionFactory.openSession().getMapper(PlayerMapper.class);
		PlayerExample example = new PlayerExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andPlayerNameLike(player.getPlayerName());
		criteria.andEmailLike(player.getEmail());
		
		int result = playerMapper.selectByExample(example).size();
		if(result >=1){
			return true;
		}
		return false;
	}
	
	private int generatePlayerId(){
		List<Player> allPlayers = getAllPlayers();
		
		int lastInsertedPlayerId = 0;
		if(allPlayers.size() >0){
		 int lastElement = allPlayers.size() - 1;
		 lastInsertedPlayerId = allPlayers.get(lastElement).getPlayerId();
		}
		
		int newPlayerId = lastInsertedPlayerId + 1;
		
		return  newPlayerId;
		//return newPlayerId;
	}


}
