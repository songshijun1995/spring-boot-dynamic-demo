package com.dynamic.dynamicdemo.entities;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "是否删除，0 未删除， 1 删除")
    @TableLogic //逻辑删除
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    @ApiModelProperty(value = "是否可用，1 可用，0 不可用")
    @TableField(fill = FieldFill.INSERT)
    private Integer available;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT) // 字段添加填充内容
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
