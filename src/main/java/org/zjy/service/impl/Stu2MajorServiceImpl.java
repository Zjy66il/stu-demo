package org.zjy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zjy.entity.Major;
import org.zjy.entity.Stu2major;
import org.zjy.entity.Stu2majorExample;
import org.zjy.entity.Student;
import org.zjy.mapper.MajorMapper;
import org.zjy.mapper.Stu2majorMapper;
import org.zjy.mapper.StudentMapper;
import org.zjy.service.Stu2MajorService;

import java.util.List;

@Service
public class Stu2MajorServiceImpl implements Stu2MajorService {
    @Autowired
    Stu2majorMapper stu2majorMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    MajorMapper majorMapper;

    @Override
    public boolean addRelation(Integer stuId, Integer majorId) {
        int ret;
        Student student = studentMapper.selectByPrimaryKey(stuId);
        if(null == student || student.getDeleted() == 1){
            return false;
        }
        Major major = majorMapper.selectByPrimaryKey(majorId);
        if(null == major || major.getDeleted() == 1){
            return false;
        }

        Stu2majorExample stu2majorExample = new Stu2majorExample();
        stu2majorExample.createCriteria()
                .andMajoridEqualTo(majorId)
                .andStudentidEqualTo(stuId);
        List<Stu2major> stu2MajorList = stu2majorMapper.selectByExample(stu2majorExample);
        Stu2major stu2major = new Stu2major();
        stu2major.setStudentid(stuId);
        stu2major.setMajorid(majorId);
        stu2major.setDeleted(0);
        if(stu2MajorList.isEmpty()){
           ret = stu2majorMapper.insertSelective(stu2major);
        }else {
            stu2major = stu2MajorList.get(0);
            stu2major.setDeleted(0);
           ret = stu2majorMapper.updateByExampleSelective(stu2major,stu2majorExample);
        }
        return ret > 0;

    }

    @Override
    public boolean updateRelation(Integer stuId, Integer majorId, Integer targetMajorId) {
        int res = 0;
        Stu2majorExample stu2majorExample = new Stu2majorExample();
        stu2majorExample.createCriteria()
                .andMajoridEqualTo(majorId)
                .andStudentidEqualTo(stuId)
                .andDeletedEqualTo(0);
        List<Stu2major> stu2majorList = stu2majorMapper.selectByExample(stu2majorExample);
        if (stu2majorList == null || stu2majorList.isEmpty()){
            return false;
        }
        Student student = studentMapper.selectByPrimaryKey(stuId);
        if(null == student || student.getDeleted() == 1){
            return false;
        }
        Major major = majorMapper.selectByPrimaryKey(majorId);
        if(null == major || student.getDeleted() == 1){
            return false;
        }

        stu2majorExample = new Stu2majorExample();
        stu2majorExample.createCriteria()
                .andMajoridEqualTo(targetMajorId)
                .andStudentidEqualTo(stuId);

        Stu2major stu2major = stu2majorList.get(0);
        stu2majorList = stu2majorMapper.selectByExample(stu2majorExample);
        if(stu2majorList.isEmpty()){
            res = stu2majorMapper.updateRelation(stuId,majorId,targetMajorId);
        }else if(stu2majorList.get(0).getDeleted() == 1){
            stu2major = new Stu2major();
            stu2major.setStudentid(stu2majorList.get(0).getId());
            stu2major.setDeleted(0);
            stu2majorMapper.updateByPrimaryKeySelective(stu2major);
            
            stu2majorMapper.delRelation(stuId,majorId);
        }else {
            return false;
        }
        return res > 0;
    }

    @Override
    public boolean delRelation(Integer stuId, Integer majorId) {

        Stu2majorExample stu2majorExample = new Stu2majorExample();
        stu2majorExample.createCriteria()
                .andMajoridEqualTo(majorId)
                .andStudentidEqualTo(stuId)
                .andDeletedEqualTo(0);
        List<Stu2major> stu2majorList = stu2majorMapper.selectByExample(stu2majorExample);
        if (stu2majorList == null || stu2majorList.isEmpty()){
            return false;
        }
        int ret = stu2majorMapper.delRelation(stuId,majorId);

        return ret > 0;
    }
}
