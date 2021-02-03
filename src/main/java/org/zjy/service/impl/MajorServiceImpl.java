package org.zjy.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zjy.entity.*;
import org.zjy.mapper.MajorMapper;
import org.zjy.mapper.Stu2majorMapper;
import org.zjy.service.MajorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private Stu2majorMapper stu2majorMapper;

    @Override
    public Major getMajor(Integer id) {
        Major major = majorMapper.selectByPrimaryKey(id);
        return major;
    }

    @Override
    public List<Major> getAllMajor() {
        MajorExample majorExample = new MajorExample();
        majorExample.createCriteria()
                .andDeletedEqualTo(0);
        List<Major> majorList = majorMapper.selectByExample(majorExample);
        return majorList;
    }

    @Override
    public boolean addMajor(Major major) {
        major.setDeleted(0);
        int ret = majorMapper.insertSelective(major);
        return ret > 0;
    }

    @Override
    public boolean updateMajor(Major major) {
        Major majorEntity = majorMapper.selectByPrimaryKey(major.getId());
        if(null == majorEntity || majorEntity.getDeleted() == 1){
            return false;
        }
        int ret = majorMapper.updateByPrimaryKeySelective(major);

        return ret > 0;
    }

    @Override
    public boolean delMajor(Integer majorId) {
        MajorExample majorExample = new MajorExample();
        majorExample.createCriteria().andIdEqualTo(majorId);
        Major major = new Major();
        major.setDeleted(1);
        majorMapper.updateByExampleSelective(major,majorExample);
        //删除关系
        Stu2major stu2major = new Stu2major();
        stu2major.setDeleted(1);
        Stu2majorExample staff2majorExample = new Stu2majorExample();
        staff2majorExample.createCriteria().andIdEqualTo(majorId);
        Integer result = stu2majorMapper.updateByExampleSelective(stu2major,staff2majorExample);

        return result > 0;
    }

    @Override
    public List<Major> listAllMajor4Stu(Integer stuId) {
        List<Major> majorList = majorMapper.listMajor4Stu(stuId);
        return majorList;
    }
}
