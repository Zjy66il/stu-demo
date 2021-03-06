package org.zjy.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zjy.entity.Stu2major;
import org.zjy.entity.Stu2majorExample;

public interface Stu2majorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu2major
     *
     * @mbg.generated
     */
    long countByExample(Stu2majorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu2major
     *
     * @mbg.generated
     */
    int deleteByExample(Stu2majorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu2major
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu2major
     *
     * @mbg.generated
     */
    int insert(Stu2major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu2major
     *
     * @mbg.generated
     */
    int insertSelective(Stu2major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu2major
     *
     * @mbg.generated
     */
    List<Stu2major> selectByExample(Stu2majorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu2major
     *
     * @mbg.generated
     */
    Stu2major selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu2major
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Stu2major record, @Param("example") Stu2majorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu2major
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Stu2major record, @Param("example") Stu2majorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu2major
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Stu2major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu2major
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Stu2major record);

    int updateRelation(@Param("stuId") Integer stuId, @Param("majorId") Integer majorId, @Param("targetMajorId") Integer targetMajorId);

    int delRelation(@Param("stuId") Integer stuId, @Param("majorId") Integer majorId);
}