package org.zjy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zjy.entity.Major;
import org.zjy.entity.Student;
import org.zjy.service.MajorService;
import org.zjy.util.ResultUtil;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @GetMapping("/findById/{id}")
    public ResultUtil getMajor(@PathVariable("id") Integer id){
        Major res = majorService.getMajor(id);
        return ResultUtil.success(res);
    }

    @GetMapping("/listMajor/{id}")
    public ResultUtil listMajor(@PathVariable("id") Integer id){
        List<Major> majorList = majorService.listAllMajor4Stu(id);
        return ResultUtil.success(majorList);
    }


    @GetMapping("/getAll")
    public ResultUtil allMajor(){
        List<Major> res = majorService.getAllMajor();
        return ResultUtil.success(res);
    }

    @PostMapping("/delete/{id}")
    public ResultUtil deleteMajor(@PathVariable("id") Integer id){
        if(majorService.delMajor(id)){
            return ResultUtil.success("success");
        }
        return ResultUtil.fail(0);
    }

    @PostMapping("/addMajor")
    public ResultUtil addMajor(@RequestBody Major major){
        if( majorService.addMajor(major)){
            return ResultUtil.success("success");
        }
        return ResultUtil.fail(0);
    }

    @PutMapping("/update")
    public ResultUtil deleteMajor(@RequestBody Major major){
        if(majorService.updateMajor(major)){
            return ResultUtil.success("success");
        }
        return ResultUtil.fail(0);
    }

}
