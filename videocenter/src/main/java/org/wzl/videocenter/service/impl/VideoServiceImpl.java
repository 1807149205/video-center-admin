package org.wzl.videocenter.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.wzl.videocenter._do.Video;
import org.wzl.videocenter.mapper.VideoMapper;
import org.wzl.videocenter.service.VideoService;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import jakarta.annotation.Resource;

@Service
public class VideoServiceImpl implements VideoService{

    @Resource
    private VideoMapper videoMapper;


    @Override
    public List<Video> getAll() {
        return videoMapper.selectList(null);
    }
    
}
