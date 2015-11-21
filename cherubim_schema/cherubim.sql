-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.33a-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for cherubim
DROP DATABASE IF EXISTS `cherubim`;
CREATE DATABASE IF NOT EXISTS `cherubim` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cherubim`;


-- Dumping structure for table cherubim.access
DROP TABLE IF EXISTS `access`;
CREATE TABLE IF NOT EXISTS `access` (
  `id` int(10) NOT NULL,
  `access_name` varchar(50) NOT NULL COMMENT 'Description of the access rights',
  PRIMARY KEY (`id`),
  UNIQUE KEY `access_name` (`access_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='access rights for the operators and players';

-- Dumping data for table cherubim.access: ~0 rows (approximately)
DELETE FROM `access`;
/*!40000 ALTER TABLE `access` DISABLE KEYS */;
/*!40000 ALTER TABLE `access` ENABLE KEYS */;


-- Dumping structure for table cherubim.character
DROP TABLE IF EXISTS `character`;
CREATE TABLE IF NOT EXISTS `character` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `character_name` varchar(250) NOT NULL COMMENT 'Name of the character',
  `gender` char(5) NOT NULL DEFAULT 'M' COMMENT 'Gender of the character',
  `level` int(255) NOT NULL DEFAULT '1' COMMENT 'Current level of the character',
  `experience` int(255) NOT NULL DEFAULT '0' COMMENT 'Character''s experience',
  `character_image` varchar(300) DEFAULT NULL COMMENT 'file path of character''s current avatar',
  `hitpoints` int(20) NOT NULL DEFAULT '30' COMMENT 'life amount of the character',
  `manapoints` int(20) NOT NULL DEFAULT '30' COMMENT 'mana or energyamount of the character',
  `gold` int(20) NOT NULL DEFAULT '30' COMMENT 'Character''s current cash',
  `statpoints` int(20) NOT NULL DEFAULT '30' COMMENT 'remaining stat point of the character. Stat point should be placed( str, agi, cons, int etc..)',
  `skillpoints` int(20) NOT NULL DEFAULT '30' COMMENT 'remaining skill point that will be placed to a particular skill',
  `strength` int(20) NOT NULL DEFAULT '30' COMMENT 'Controls the maximum weight the character can carry and the damage the character can give',
  `agility` int(20) NOT NULL DEFAULT '30' COMMENT 'Determines how fast the character can attack, accuracy and evasion',
  `constitution` int(20) NOT NULL DEFAULT '30' COMMENT 'Focuses on Vitality(+HitPoints), Stamina, Resistance against special damage ',
  `intelligence` int(20) NOT NULL DEFAULT '30' COMMENT 'Focuses on Energy(+ManaPoints) and magical damage',
  `defense` int(20) NOT NULL DEFAULT '30' COMMENT 'Decreases the damage that is dealt by an opponent',
  `luck` int(20) NOT NULL DEFAULT '30' COMMENT 'Increases the chance to discover/obtain rare items and deal critical hits',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Player''s created character';

-- Dumping data for table cherubim.character: ~0 rows (approximately)
DELETE FROM `character`;
/*!40000 ALTER TABLE `character` DISABLE KEYS */;
/*!40000 ALTER TABLE `character` ENABLE KEYS */;


-- Dumping structure for table cherubim.character_job
DROP TABLE IF EXISTS `character_job`;
CREATE TABLE IF NOT EXISTS `character_job` (
  `character_id` int(10) NOT NULL,
  `job_id` int(10) NOT NULL,
  KEY `FK2_CHARACTER` (`character_id`),
  KEY `FK1_JOBS` (`job_id`),
  CONSTRAINT `FK1_JOBS` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2_CHARACTER` FOREIGN KEY (`character_id`) REFERENCES `character` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Character''s Job';

-- Dumping data for table cherubim.character_job: ~0 rows (approximately)
DELETE FROM `character_job`;
/*!40000 ALTER TABLE `character_job` DISABLE KEYS */;
/*!40000 ALTER TABLE `character_job` ENABLE KEYS */;


-- Dumping structure for table cherubim.character_race
DROP TABLE IF EXISTS `character_race`;
CREATE TABLE IF NOT EXISTS `character_race` (
  `character_id` int(10) NOT NULL,
  `race_id` int(10) NOT NULL,
  KEY `FK1_CHARACTER` (`character_id`),
  KEY `FK2_RACE` (`race_id`),
  CONSTRAINT `FK2_RACE` FOREIGN KEY (`race_id`) REFERENCES `race` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK1_CHARACTER` FOREIGN KEY (`character_id`) REFERENCES `character` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='character''s race chosen by the player';

-- Dumping data for table cherubim.character_race: ~0 rows (approximately)
DELETE FROM `character_race`;
/*!40000 ALTER TABLE `character_race` DISABLE KEYS */;
/*!40000 ALTER TABLE `character_race` ENABLE KEYS */;


-- Dumping structure for table cherubim.character_skill
DROP TABLE IF EXISTS `character_skill`;
CREATE TABLE IF NOT EXISTS `character_skill` (
  `character_id` int(10) NOT NULL,
  `skill_id` int(10) NOT NULL,
  `skill_level` int(10) DEFAULT '0' COMMENT 'current skill level for this character',
  KEY `FK1_CHAR_ID` (`character_id`),
  KEY `FK2_SKILLS_ID` (`skill_id`),
  CONSTRAINT `FK1_CHAR_ID` FOREIGN KEY (`character_id`) REFERENCES `character` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2_SKILLS_ID` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='character''s skill and its current level\r\n';

-- Dumping data for table cherubim.character_skill: ~0 rows (approximately)
DELETE FROM `character_skill`;
/*!40000 ALTER TABLE `character_skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `character_skill` ENABLE KEYS */;


-- Dumping structure for table cherubim.job
DROP TABLE IF EXISTS `job`;
CREATE TABLE IF NOT EXISTS `job` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(250) NOT NULL COMMENT 'name of the job',
  `job_description` varchar(250) NOT NULL COMMENT 'Brief description of the job',
  `job_image` varchar(300) NOT NULL COMMENT 'file path of the job image/avatar',
  `is_available` int(3) NOT NULL DEFAULT '0' COMMENT 'Is this job available?',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Character''s Job or Class';

-- Dumping data for table cherubim.job: ~0 rows (approximately)
DELETE FROM `job`;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
/*!40000 ALTER TABLE `job` ENABLE KEYS */;


-- Dumping structure for table cherubim.jobs_skill
DROP TABLE IF EXISTS `jobs_skill`;
CREATE TABLE IF NOT EXISTS `jobs_skill` (
  `job_id` int(10) NOT NULL,
  `skill_id` int(10) NOT NULL,
  KEY `FK1_JOB` (`job_id`),
  KEY `FK2_SKILLS` (`skill_id`),
  CONSTRAINT `FK1_JOB` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2_SKILLS` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='job related skills';

-- Dumping data for table cherubim.jobs_skill: ~0 rows (approximately)
DELETE FROM `jobs_skill`;
/*!40000 ALTER TABLE `jobs_skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobs_skill` ENABLE KEYS */;


-- Dumping structure for table cherubim.operator
DROP TABLE IF EXISTS `operator`;
CREATE TABLE IF NOT EXISTS `operator` (
  `id` int(10) NOT NULL,
  `operator_id` int(10) NOT NULL COMMENT 'operator''s unique id',
  `operator_user_name` varchar(250) NOT NULL,
  `operator_first_name` varchar(250) NOT NULL,
  `operator_middle_name` varchar(250) NOT NULL,
  `operator_last_name` varchar(250) NOT NULL,
  `operator_home_address` varchar(250) NOT NULL,
  `operator_home_address2` varchar(250) DEFAULT NULL,
  `operator_home_city` varchar(250) NOT NULL,
  `operator_home_state` varchar(250) DEFAULT NULL,
  `operator_home_zip` varchar(250) DEFAULT NULL COMMENT 'zip address of the operator''s current address',
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL COMMENT 'operator''s password',
  `status` int(3) NOT NULL DEFAULT '0' COMMENT 'Is Active, Inactive, Suspended',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `operator_full_name` (`operator_first_name`,`operator_middle_name`,`operator_last_name`),
  UNIQUE KEY `operator_user_name` (`operator_user_name`),
  UNIQUE KEY `operator_id` (`operator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='responsible for monitoring player''s activities and creating/modifying jobs, races, skills and other operators';

-- Dumping data for table cherubim.operator: ~0 rows (approximately)
DELETE FROM `operator`;
/*!40000 ALTER TABLE `operator` DISABLE KEYS */;
/*!40000 ALTER TABLE `operator` ENABLE KEYS */;


-- Dumping structure for table cherubim.player
DROP TABLE IF EXISTS `player`;
CREATE TABLE IF NOT EXISTS `player` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'table id',
  `player_id` int(10) NOT NULL COMMENT 'player''s unique id',
  `player_name` varchar(250) NOT NULL COMMENT 'Unique player name/user name',
  `email` varchar(50) NOT NULL COMMENT 'player''s email address',
  `password` varchar(50) NOT NULL COMMENT 'player''s login password',
  `birthdate` date NOT NULL,
  `gender` char(5) NOT NULL DEFAULT 'M',
  `player_image` varchar(300) DEFAULT NULL COMMENT 'file path to player''s image/avatar',
  `is_facebook_acct` char(5) NOT NULL DEFAULT 'N' COMMENT 'Is the information came from facebook',
  `status` int(3) NOT NULL DEFAULT '0' COMMENT 'Is Active, Inactive, Suspended',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `player_name` (`player_name`),
  UNIQUE KEY `operator_id` (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contains information of the player';

-- Dumping data for table cherubim.player: ~0 rows (approximately)
DELETE FROM `player`;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
/*!40000 ALTER TABLE `player` ENABLE KEYS */;


-- Dumping structure for table cherubim.player_character
DROP TABLE IF EXISTS `player_character`;
CREATE TABLE IF NOT EXISTS `player_character` (
  `player_id` int(10) NOT NULL,
  `character_id` int(10) NOT NULL,
  KEY `FK2_CHARACTERS` (`character_id`),
  KEY `FK1_PLAYER` (`player_id`),
  CONSTRAINT `FK1_PLAYER` FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2_CHARACTERS` FOREIGN KEY (`character_id`) REFERENCES `character` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Player''s characters';

-- Dumping data for table cherubim.player_character: ~0 rows (approximately)
DELETE FROM `player_character`;
/*!40000 ALTER TABLE `player_character` DISABLE KEYS */;
/*!40000 ALTER TABLE `player_character` ENABLE KEYS */;


-- Dumping structure for table cherubim.race
DROP TABLE IF EXISTS `race`;
CREATE TABLE IF NOT EXISTS `race` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `race_name` varchar(250) NOT NULL COMMENT 'Name of Race',
  `race_description` varchar(250) NOT NULL COMMENT 'Brief description of the race',
  `race_image` varchar(250) NOT NULL COMMENT 'file path of the race avatar/image',
  `is_available` int(3) NOT NULL DEFAULT '0' COMMENT 'Is this race available?',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='character''s race chosen by the player (e.g. humans, elves, orcs, dwarves, goblins)';

-- Dumping data for table cherubim.race: ~0 rows (approximately)
DELETE FROM `race`;
/*!40000 ALTER TABLE `race` DISABLE KEYS */;
/*!40000 ALTER TABLE `race` ENABLE KEYS */;


-- Dumping structure for table cherubim.race_skill
DROP TABLE IF EXISTS `race_skill`;
CREATE TABLE IF NOT EXISTS `race_skill` (
  `race_id` int(10) NOT NULL,
  `skill_id` int(10) NOT NULL,
  KEY `FK1_RACE` (`race_id`),
  KEY `FK2_SKILL` (`skill_id`),
  CONSTRAINT `FK2_SKILL` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK1_RACE` FOREIGN KEY (`race_id`) REFERENCES `race` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='race related skills';

-- Dumping data for table cherubim.race_skill: ~0 rows (approximately)
DELETE FROM `race_skill`;
/*!40000 ALTER TABLE `race_skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `race_skill` ENABLE KEYS */;


-- Dumping structure for table cherubim.skills
DROP TABLE IF EXISTS `skills`;
CREATE TABLE IF NOT EXISTS `skills` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(255) NOT NULL COMMENT 'name of skill',
  `skill_description` varchar(255) NOT NULL COMMENT 'description of the skill',
  `required_level` int(10) DEFAULT '0' COMMENT 'Required character level for the skill to be active',
  `is_parent` tinyint(3) NOT NULL DEFAULT '0' COMMENT 'Is this a parent skill',
  `parent_skill` int(10) DEFAULT NULL COMMENT 'Skill id of its parent skill if there is any',
  `is_available` tinyint(3) NOT NULL DEFAULT '0' COMMENT 'Is this skill available?',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='contains all of the skills that the character may use';

-- Dumping data for table cherubim.skills: ~0 rows (approximately)
DELETE FROM `skills`;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;


-- Dumping structure for table cherubim.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) NOT NULL,
  `email` varchar(50) NOT NULL COMMENT 'will act as a username of the player/operator',
  `username` varchar(250) NOT NULL COMMENT 'will act as a username of the player/operator',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='users can be a player or an operator';

-- Dumping data for table cherubim.users: ~0 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Dumping structure for table cherubim.user_access
DROP TABLE IF EXISTS `user_access`;
CREATE TABLE IF NOT EXISTS `user_access` (
  `user_id` int(10) NOT NULL,
  `access_id` int(10) NOT NULL,
  KEY `FK1_USER` (`user_id`),
  KEY `FK2_ACCESS` (`access_id`),
  CONSTRAINT `FK1_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2_ACCESS` FOREIGN KEY (`access_id`) REFERENCES `access` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='user''s access rights';

-- Dumping data for table cherubim.user_access: ~0 rows (approximately)
DELETE FROM `user_access`;
/*!40000 ALTER TABLE `user_access` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_access` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
