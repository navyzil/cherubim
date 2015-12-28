package com.zil.cherubim.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zil.cherubim.dao.CharacterDao;
import com.zil.cherubim.mapper.CharacterMapper;
import com.zil.cherubim.model.Character;
import com.zil.cherubim.model.CharacterExample;

@Repository
public class CharacterDaoImpl implements CharacterDao {
	public static final Logger LOGGER = LoggerFactory.getLogger(CharacterDaoImpl.class);
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Override
	public List<Character> getAllCharacters() {
		CharacterExample example = new CharacterExample();
		CharacterMapper characterMapper = sessionFactory.openSession().getMapper(CharacterMapper.class);
		
		return characterMapper.selectByExample(example);
	}

	@Override
	public Character getCharacterInfo(Character character) {
		CharacterMapper characterMapper = sessionFactory.openSession().getMapper(CharacterMapper.class);
		characterMapper = sessionFactory.openSession().getMapper(CharacterMapper.class);
		
		return characterMapper.selectByPrimaryKey(character.getId());
	}

	@Override
	public int createCharacter(Character character) {
		CharacterMapper characterMapper = sessionFactory.openSession().getMapper(CharacterMapper.class);
		int result = characterMapper.insertSelective(character);
		if(result == 1){
			LOGGER.debug("character.getId():{}",character.getId());
			return character.getId();
		}
		return 0;
	}
	
	@Override
	public boolean updateCharacter(Character character) {
		CharacterMapper characterMapper = sessionFactory.openSession().getMapper(CharacterMapper.class);
		int result = characterMapper.updateByPrimaryKeySelective(character);
		if(result == 1){
			return true;
		}
		return false;
	}

	
	@Override
	public boolean deleteCharacter(Character character) {
		CharacterMapper characterMapper = sessionFactory.openSession().getMapper(CharacterMapper.class);
		int result = characterMapper.deleteByPrimaryKey(character.getId());
		if(result == 1){
			return true;
		}
		return false;
	}
}
