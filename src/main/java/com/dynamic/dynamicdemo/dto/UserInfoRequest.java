package com.dynamic.dynamicdemo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserInfoRequest {
    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "性别 0未知 1女 2男")
    private Integer sex;

    @ApiModelProperty(value = "邮箱")
    private String email;
}
