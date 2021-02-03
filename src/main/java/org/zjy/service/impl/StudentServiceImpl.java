package org.zjy.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zjy.entity.Stu2major;
import org.zjy.entity.Stu2majorExample;
import org.zjy.entity.Student;
import org.zjy.entity.StudentExample;
import org.zjy.mapper.Stu2majorMapper;
import org.zjy.mapper.StudentMapper;
import org.zjy.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private Stu2majorMapper stu2majorMapper;

    @Override
    public List<Student> getAllStudent(){
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria()
                .andDeletedEqualTo(0);
        List<Student>  studentList = studentMapper.selectByExample(studentExample);
        return studentList;
    }

    @Override
    public int addStudent(Integer majorId,Student student) {

        student.setDeleted(0);
        studentMapper.insert(student);

        Stu2major stu2major = new Stu2major();
        stu2major.setDeleted(0);
        stu2major.setStudentid(student.getId());
        stu2major.setMajorid(majorId);
        stu2majorMapper.insertSelective(stu2major);

        return student.getId();
    }

    @Override
    public boolean updateStu(Student stu) {
        Student student = studentMapper.selectByPrimaryKey(stu.getId());
        if(null == student || student.getDeleted() == 1){
            return false;
        }
        int ret = studentMapper.updateByPrimaryKeySelective(stu);

        return ret > 0;
    }

    @Override
    public boolean delStu(Integer stuId) {

        StudentExample stuExample = new StudentExample();
        stuExample.createCriteria().andIdEqualTo(stuId);
        Student stu = new Student();
        stu.setDeleted(1);
        studentMapper.updateByExampleSelective(stu,stuExample);
        //删除关系
        Stu2major stu2major = new Stu2major();
        stu2major.setDeleted(1);
        Stu2majorExample staff2majorExample = new Stu2majorExample();
        staff2majorExample.createCriteria().andStudentidEqualTo(stuId);
        Integer result = stu2majorMapper.updateByExampleSelective(stu2major,staff2majorExample);

        return result > 0;
    }

    @Override
    public Student getStu(Integer id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    @Override
    public List<Student> listStu4Major(Integer majorId) {
        List<Student>  stuList = studentMapper.listStu4Major(majorId);
        return stuList;
    }
}
