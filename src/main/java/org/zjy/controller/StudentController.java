package org.zjy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zjy.entity.Student;
import org.zjy.service.Stu2MajorService;
import org.zjy.service.StudentService;
import org.zjy.util.ResultUtil;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private Stu2MajorService stu2MajorService;

    @GetMapping("/getAll")
    public ResultUtil getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        return ResultUtil.success(studentList);
    }

    @GetMapping("/getById/{id}")
    public ResultUtil getAllStudent(@PathVariable("id") Integer id){
        Student student = studentService.getStu(id);
        return ResultUtil.success(student);
    }


    @GetMapping("get/{majorId}")
    public ResultUtil getStudent(@PathVariable("majorId")Integer majorId){
        List<Student> res = studentService.listStu4Major(majorId);
        return ResultUtil.success(res);
    }

    @PostMapping ("add/{majorId}")
    public ResultUtil addStudent(@PathVariable("majorId")Integer majorId,@RequestBody Student student) {
        int res = studentService.addStudent(majorId,student);
        return ResultUtil.success(res);
    }

    @PostMapping("/delete/{id}")
    public ResultUtil deleteStu(@PathVariable("id") Integer id){
        if(studentService.delStu(id)){
            return ResultUtil.success("success");
        }
        return ResultUtil.fail(0);
    }



}
