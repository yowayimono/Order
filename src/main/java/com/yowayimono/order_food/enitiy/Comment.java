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

    @TableField(value = "parentId")
    private Long parentId;

    @TableField(value = "content")
    private String content;

    @TableField(value = "createtime")
    private LocalDateTime createTime;

    @TableField(value = "deletetime")
    private LocalDateTime deletetime;


    @TableField(value = "likeCount")
    private Integer likeCount;

    @TableField(value = "userId")
    private Long userId;

    @TableField(value = "ProductId")
    private Long ProductId;

    @TableField(value = "likedUserIds")
    private String likedUserIds;
}