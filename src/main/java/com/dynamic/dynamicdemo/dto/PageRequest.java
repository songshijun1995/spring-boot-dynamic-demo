package com.dynamic.dynamicdemo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageRequest {

    @ApiModelProperty(value = "当前页")
    protected Integer pageNum=1;

    @ApiModelProperty(value = "每页多少")
    protected Integer pageSize=10;
}
