package org.wzl.videocenter.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.wzl.videocenter._do.Video;
import org.wzl.videocenter.dto.VideoSearchDTO;
import org.wzl.videocenter.mapper.VideoMapper;
import org.wzl.videocenter.service.VideoCategoryService;
import org.wzl.videocenter.service.VideoService;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import jakarta.annotation.Resource;
import org.wzl.videocenter.vo.VideoVO;

@Service
public class VideoServiceImpl implements VideoService{

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private VideoCategoryService videoCategoryService;

    @Override
    public List<Video> getAll() {
        return videoMapper.selectList(null);
    }

    @Override
    public IPage<VideoVO> getVideoPage(long page, long size, VideoSearchDTO videoSearchDTO) {
        IPage<Video> resPage = new Page<>(page, size);
        var videoLambdaQueryWrapper = Wrappers.<Video>lambdaQuery();

        if (!ObjectUtils.isEmpty(videoSearchDTO.getVideoName())) {
            videoLambdaQueryWrapper.like(Video::getVideoName, videoSearchDTO.getVideoName());
        }

        if (!ObjectUtils.isEmpty(videoSearchDTO.getVideoStatus())) {
            videoLambdaQueryWrapper.eq(Video::getStatus, videoSearchDTO.getVideoStatus());
        }

        IPage<Video> videoIPage = videoMapper.selectPage(resPage, videoLambdaQueryWrapper);
        return videoIPage.convert(this::getVO);
    }

    private VideoVO getVO(Video video) {
        VideoVO vo = new VideoVO();
        vo.setCategories(videoCategoryService.getCategoriesByVideoId(video.getId()));
        vo.setVideoName(video.getVideoName());
        vo.setVideoId(video.getId());
        vo.setVideoStatus(video.getStatus());
        vo.setVideoCreateDate(video.getCreateDate());
        vo.setVideoUpdateDate(video.getUpdateDate());
        return vo;
    }


}
