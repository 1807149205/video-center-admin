package org.wzl.videocenter.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.wzl.videocenter._do.VideoCategory;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VideoCategoryMapperTest {

    @Autowired
    private VideoCategoryMapper videoCategoryMapper;

    @Test
    public void testGetVideoCategoryById() {
        // 这里传入一个你想要测试的ID值
        String videoId = "1369ac12ac006cde0f1a74eb3a813d7f";

        // 调用mapper的方法
        List<VideoCategory> result = videoCategoryMapper.getVideoCategoryById(videoId);

        // 进行断言，检查返回结果是否符合预期
        Assertions.assertNotNull(result, "The result should not be null");
        Assertions.assertFalse(result.isEmpty(), "The result list should not be empty");

    }

}
