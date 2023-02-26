package com.atguigu.ggkt.vod.service;


import com.atguigu.ggkt.model.vod.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-02-18
 */
public interface VideoService extends IService<Video> {

    //删除小节 同时删除小节里面视频
    void removeVideoById(Long id);
//
    void removeVideoByCourseId(Long id);
}
