package com.dynamic.dynamicdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dynamic.dynamicdemo.dto.PageRequest;
import com.dynamic.dynamicdemo.dto.UserInfoRequest;
import com.dynamic.dynamicdemo.entities.UserInfo;
import com.dynamic.dynamicdemo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "/api/userinfo", tags = {"userinfo"})
@RequestMapping("/api/userinfo")
@RestController
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @PostMapping("/saveUser")
    @ApiOperation(value = "saveUser")
    public String saveUser(@RequestBody UserInfoRequest request) {
        return userInfoService.saveUser(request);
    }

    @GetMapping("/pageUser")
    @ApiOperation(value = "pageUser")
    public IPage<UserInfo> pageUser(PageRequest request) {
        return userInfoService.pageUser(request);
    }
}
