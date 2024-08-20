package org.wzl.videocenter._do;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @TableName t_video_category_relation
 */
@TableName(value ="t_video_category_relation")
@Data
public class VideoCategoryRelation implements Serializable {
    /**
     *
     */
    private String videoId;

    /**
     *
     */
    private String categoryId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}