package org.zjy.service;

import org.zjy.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    int addStudent(Integer majorId,Student student);

    boolean updateStu(Student student);

    boolean delStu(Integer stuId);

    Student getStu(Integer id);

    List<Student> listStu4Major(Integer majorId);

}
