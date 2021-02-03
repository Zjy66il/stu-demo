package org.zjy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zjy.entity.Major;
import org.zjy.entity.MajorExample;

@Mapper
public interface MajorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated
     */
    long countByExample(MajorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated
     */
    int deleteByExample(MajorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated
     */
    int insert(Major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated
     */
    int insertSelective(Major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated
     */
    List<Major> selectByExample(MajorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated
     */
    Major selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Major record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Major record);

    List<Major> listMajor4Stu(@Param("stuId") Integer stuId);
}