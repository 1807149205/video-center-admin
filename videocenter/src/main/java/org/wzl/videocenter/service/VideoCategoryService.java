package org.wzl.videocenter.service;

import org.wzl.videocenter.vo.VideoCategoryVO;

import java.util.List;

public interface VideoCategoryService {
    List<VideoCategoryVO> getCategoriesByVideoId(String id);
}
