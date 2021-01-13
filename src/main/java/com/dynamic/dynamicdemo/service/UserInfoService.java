package com.dynamic.dynamicdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dynamic.dynamicdemo.dto.PageRequest;
import com.dynamic.dynamicdemo.dto.UserInfoRequest;
import com.dynamic.dynamicdemo.entities.UserInfo;

public interface UserInfoService extends IService<UserInfo> {
    String saveUser(UserInfoRequest request);

    IPage<UserInfo> pageUser(PageRequest request);

    String saveUserBath(UserInfoRequest request);

    String updateUserBath();
}
