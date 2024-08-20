package org.wzl.videocenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.wzl.videocenter._do.VideoCategory;

import java.util.List;


/**
* @author 卫志龙
* @description 针对表【t_video】的数据库操作Mapper
* @createDate 2024-07-14 18:23:11
* @Entity org.wzl.backend._do.Video
*/
public interface VideoCategoryMapper extends BaseMapper<VideoCategory> {
    
    List<VideoCategory> getVideoCategoryById(String id);

}