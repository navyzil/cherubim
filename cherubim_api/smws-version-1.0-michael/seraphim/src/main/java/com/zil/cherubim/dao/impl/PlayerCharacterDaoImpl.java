package com.zil.cherubim.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zil.cherubim.dao.PlayerCharacterDao;
import com.zil.cherubim.mapper.PlayerCharacterMapper;
import com.zil.cherubim.model.Player;
import com.zil.cherubim.model.PlayerCharacter;
import com.zil.cherubim.model.PlayerCharacterExample;
import com.zil.cherubim.model.PlayerCharacterExample.Criteria;

@Repository
public class PlayerCharacterDaoImpl implements PlayerCharacterDao {
	public static final Logger LOGGER = LoggerFactory.getLogger(PlayerCharacterDaoImpl.class);
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public List<PlayerCharacter> getAllPlayersCharacters(Player player) {
		PlayerCharacterExample example = new PlayerCharacterExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andPlayerIdEqualTo(player.getPlayerId());
	
		PlayerCharacterMapper playerCharacterMapper = sessionFactory.openSession().getMapper(PlayerCharacterMapper.class);		
		
		return playerCharacterMapper.selectByExample(example);
	}

	@Override
	public boolean savePlayerCharacter(PlayerCharacter playerCharacter) {
		PlayerCharacterMapper playerCharacterMapper = sessionFactory.openSession().getMapper(PlayerCharacterMapper.class);
		int result = playerCharacterMapper.insertSelective(playerCharacter);
		if(result == 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePlayerCharacter(PlayerCharacter playerCharacter) {
		// TODO Auto-generated method stub
		PlayerCharacterMapper playerCharacterMapper = sessionFactory.openSession().getMapper(PlayerCharacterMapper.class);
		PlayerCharacterExample example = new PlayerCharacterExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andPlayerIdEqualTo(playerCharacter.getPlayerId());
		criteria.andCharacterIdEqualTo(playerCharacter.getCharacterId());
		int result = playerCharacterMapper.deleteByExample(example);
		if(result == 1){
			return true;
		}
		return false;
	}

}
