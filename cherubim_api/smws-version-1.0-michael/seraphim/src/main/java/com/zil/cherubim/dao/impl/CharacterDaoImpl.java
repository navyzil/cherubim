package com.zil.cherubim.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zil.cherubim.dao.CharacterDao;
import com.zil.cherubim.model.Character;

@Repository
public class CharacterDaoImpl implements CharacterDao {
	public static final Logger LOGGER = LoggerFactory.getLogger(CharacterDaoImpl.class);
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Override
	public List<Character> getAllCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Character getCharacterInfo(Character character) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveCharacter(Character character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCharacter(Character character) {
		// TODO Auto-generated method stub
		return false;
	}

}
