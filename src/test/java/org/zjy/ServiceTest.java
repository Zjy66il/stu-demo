package org.zjy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.zjy.entity.Major;
import org.zjy.service.MajorService;
import org.zjy.service.Stu2MajorService;
import org.zjy.service.StudentService;

import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private Stu2MajorService stu2MajorService;

    @Autowired
    private MajorService  majorService;

    @Test
    public void testListStu(){
/*        List<Student> list = studentService.listStu4Major(1);
        for(Student stu : list){
            System.out.println(stu.getName());
        }*/
        System.out.println(studentService.getStu(1).getName());

    }

    @Test
    public void testListMajor(){
        /*List<Major> list = majorService.listAllMajor4Stu(3);
        for(Major stu : list){
            System.out.println(stu.getName());
        }*/
        System.out.println(majorService.getMajor(4).getName());


    }

    @Test
    public void testRelation(){
       /* stu2MajorService.delRelation(1,2);
        System.out.println("success");*/
/*
        System.out.println(stu2MajorService.updateRelation(2,1,2));
*/
        System.out.println(stu2MajorService.addRelation(2,1));

    }

}
