package org.wzl.videocenter.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class VideoVO {

    private String videoId;

    /**
     *
     */
    private String videoName;

    /**
     * 视频时间，单位秒
     */
    private Integer videoTime;

    /**
     *
     */
    private String uId;

    /**
     *
     */
    private Integer videoStatus;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm")
    private LocalDateTime videoCreateDate;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm")
    private LocalDateTime videoUpdateDate;

    private List<VideoCategoryVO> categories;

}
