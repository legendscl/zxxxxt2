package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@CrossOrigin //跨域
public class TeacherController {
        @Autowired
        private TeacherService teacherService;
//        1 查询所有讲师
    @GetMapping("findAll")
    public Result findAllTeacher() {
        //模拟异常
//        try {
//            int i = 10/0;
//        }catch (Exception e) {
//            //抛出异常
//            throw new GgktException(201,"执行自定义异常处理GgktException");
//        }

//{
//  "code": 201,
//  "message": "执行自定义异常处理GgktException",
//  "data": null
//}


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

//15.15.bq.bq
//3 条件查询分页
@ApiOperation("条件查询分页")
@PostMapping("findQueryPage/{current}/{limit}")
public Result findPage(@PathVariable long current,
                       @PathVariable long limit,
                       @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
    //创建page对象,
    //        Getmapping，@RequestBody(required = false)，方框内手动输入数据
    ////        现在是以为jsion数据提交
    Page<Teacher> pageParam = new Page<>(current,limit);
    //判断teacherQueryVo对象是否为空
    if(teacherQueryVo == null) {//查询全部
        IPage<Teacher> pageModel =
                teacherService.page(pageParam,null);
        return Result.ok(pageModel);
    } else {
        //获取条件值，
        String name = teacherQueryVo.getName();
        Integer level = teacherQueryVo.getLevel();
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();
        //进行非空判断，条件封装
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)) {
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(joinDateBegin)) {
            wrapper.ge("join_date",joinDateBegin);
        }
        if(!StringUtils.isEmpty(joinDateEnd)) {
            wrapper.le("join_date",joinDateEnd);
        }
        //调用方法分页查询
        IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
        //返回
        return Result.ok(pageModel);
    }
}



     //16.16.bq.bq
    //4 添加讲师
    @ApiOperation("添加讲师")
    @PostMapping("saveTeacher")
    public Result saveTeacher(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.save(teacher);
        if(isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }
//        16.16.bq.bq


//    17.17.bq.bq
//5 修改-根据id查询
@ApiOperation("根据id查询")
@GetMapping("getTeacher/{id}")
public Result getTeacher(@PathVariable Long id) {
    Teacher teacher = teacherService.getById(id);
    return Result.ok(teacher);
}

    //6 修改-最终实现
    // {...}
    @ApiOperation("修改最终实现")
    @PostMapping("updateTeacher")
    public Result updateTeacher(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.updateById(teacher);
        if(isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }
    //    17.17.bq.bq


//18.18.bq.bq
    //7 批量删除讲师
    // json数组 [1,2,3],@RequestBody接收jsion数据，传入数组
    @ApiOperation("批量删除讲师")
    @DeleteMapping("removeBatch")
    public Result removeBatch(@RequestBody List<Long> idList) {
        boolean isSuccess = teacherService.removeByIds(idList);
        if(isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }
//18.18.bq.bq





}



//15.15.bq.bq



//3.3/bq.bq

