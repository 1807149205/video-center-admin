package org.wzl.videocenter.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VideoCategoryVO {

    @TableId
    private String id;

    /**
     *
     */
    private String categoryName;

    /**
     *
     */
    private String parentId;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm")
    private LocalDateTime createDate;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm")
    private LocalDateTime updateDate;

}
