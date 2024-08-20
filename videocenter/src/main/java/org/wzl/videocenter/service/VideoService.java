package org.wzl.videocenter.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.wzl.videocenter._do.Video;
import org.wzl.videocenter.dto.VideoSearchDTO;
import org.wzl.videocenter.vo.VideoVO;

public interface VideoService {
    List<Video> getAll();

    IPage<VideoVO> getVideoPage(long page, long size, VideoSearchDTO videoSearchDTO);
}
