package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.Subject;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author atguigu
 * @since 2023-02-15
 */
@Repository
public interface SubjectMapper extends BaseMapper<Subject> {


}
