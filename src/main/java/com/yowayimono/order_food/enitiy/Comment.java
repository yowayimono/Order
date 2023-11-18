package com.yowayimono.order_food.enitiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("or_comment")
public class Comment {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String content;

    @TableField(value = "commentTime")
    private LocalDateTime commentTime;

    @TableField(value = "likeCount")
    private Integer likeCount;

    @TableField(value = "userId")
    private Long userId;

    @TableField(value = "thingId")
    private Long thingId;

    @TableField(value = "likedUserIds")
    private String likedUserIds;


}