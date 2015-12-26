package com.zil.cherubim.mapper;

import com.zil.cherubim.model.RaceSkill;
import com.zil.cherubim.model.RaceSkillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RaceSkillMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race_skill
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    int countByExample(RaceSkillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race_skill
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    int deleteByExample(RaceSkillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race_skill
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race_skill
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    int insert(RaceSkill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race_skill
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    int insertSelective(RaceSkill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race_skill
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    List<RaceSkill> selectByExample(RaceSkillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race_skill
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    RaceSkill selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race_skill
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    int updateByExampleSelective(@Param("record") RaceSkill record, @Param("example") RaceSkillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race_skill
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    int updateByExample(@Param("record") RaceSkill record, @Param("example") RaceSkillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race_skill
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    int updateByPrimaryKeySelective(RaceSkill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race_skill
     *
     * @mbggenerated Sat Dec 26 21:53:38 CST 2015
     */
    int updateByPrimaryKey(RaceSkill record);
}