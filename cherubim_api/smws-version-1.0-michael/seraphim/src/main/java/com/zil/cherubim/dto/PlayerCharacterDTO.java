package com.zil.cherubim.dto;

import java.util.List;

public class PlayerCharacterDTO {
	private Integer playerId;
	private String playerName;
	private String characterName;
	private Character gender;
	private Integer level;
	private Integer experience;
	private String chracterImage;
	private Integer hitpoints;
	private Integer manapoints;
	private Integer gold;
	private Integer statpoints;
	private Integer skillpoints;
	public Integer getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public String getChracterImage() {
		return chracterImage;
	}
	public void setChracterImage(String chracterImage) {
		this.chracterImage = chracterImage;
	}
	public Integer getHitpoints() {
		return hitpoints;
	}
	public void setHitpoints(Integer hitpoints) {
		this.hitpoints = hitpoints;
	}
	public Integer getManapoints() {
		return manapoints;
	}
	public void setManapoints(Integer manapoints) {
		this.manapoints = manapoints;
	}
	public Integer getGold() {
		return gold;
	}
	public void setGold(Integer gold) {
		this.gold = gold;
	}
	public Integer getStatpoints() {
		return statpoints;
	}
	public void setStatpoints(Integer statpoints) {
		this.statpoints = statpoints;
	}
	public Integer getSkillpoints() {
		return skillpoints;
	}
	public void setSkillpoints(Integer skillpoints) {
		this.skillpoints = skillpoints;
	}
	
}
