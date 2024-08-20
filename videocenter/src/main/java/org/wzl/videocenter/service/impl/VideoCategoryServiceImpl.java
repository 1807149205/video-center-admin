package org.wzl.videocenter.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.wzl.videocenter._do.VideoCategory;
import org.wzl.videocenter._do.VideoCategoryRelation;
import org.wzl.videocenter.mapper.VideoCategoryMapper;
import org.wzl.videocenter.mapper.VideoCategoryRelationMapper;
import org.wzl.videocenter.service.VideoCategoryService;
import org.wzl.videocenter.vo.VideoCategoryVO;

import java.util.List;

@Service
public class VideoCategoryServiceImpl implements VideoCategoryService {

    private final VideoCategoryMapper videoCategoryMapper;
    private final VideoCategoryRelationMapper videoCategoryRelationMapper;

    public VideoCategoryServiceImpl(VideoCategoryMapper videoCategoryMapper,
                                    VideoCategoryRelationMapper videoCategoryRelationMapper) {
        this.videoCategoryMapper = videoCategoryMapper;
        this.videoCategoryRelationMapper = videoCategoryRelationMapper;
    }

    @Override
    public List<VideoCategoryVO> getCategoriesByVideoId(String videoId) {
        return videoCategoryMapper.getVideoCategoryById(videoId)
                .stream().map(this::getVO).toList();
    }

    private VideoCategoryVO getVO(VideoCategory videoCategory) {
        VideoCategoryVO vo = new VideoCategoryVO();
        BeanUtils.copyProperties(videoCategory, vo);
        return vo;
    }

}
