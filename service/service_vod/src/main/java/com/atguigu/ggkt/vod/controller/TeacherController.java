package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2023-01-28
 */
//3.3/bq.bq
@RestController
//http://localhost:8301/admin/vod/teacher/findAll
@RequestMapping("/admin/vod/teacher")
public class TeacherController {
        @Autowired
        private TeacherService teacherService;
//        1 查询所有讲师
    @GetMapping("findAll")
    public Result findAllTeacher() {
        //调用service方法
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }

//    2.逻辑删除讲师
    @DeleteMapping("remove/{id}")
    public Result removeTeacher(@PathVariable Long id){
        boolean isSuccess = teacherService.removeById(id);

        if(isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }

    }
}
//3.3/bq.bq

