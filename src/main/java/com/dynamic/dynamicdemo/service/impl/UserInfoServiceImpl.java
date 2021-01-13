package com.dynamic.dynamicdemo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dynamic.dynamicdemo.dto.PageRequest;
import com.dynamic.dynamicdemo.dto.UserInfoRequest;
import com.dynamic.dynamicdemo.entities.BaseEntity;
import com.dynamic.dynamicdemo.entities.UserInfo;
import com.dynamic.dynamicdemo.mapper.UserInfoMapper;
import com.dynamic.dynamicdemo.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveUser(UserInfoRequest request) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(request, userInfo);
        boolean save = save(userInfo);
        if (!save) {
            throw new RuntimeException("添加用户失败");
        }
        return "添加用户成功";
    }

    @DS("slave_1")
    @Override
    public IPage<UserInfo> pageUser(PageRequest request) {
        return page(new Page<>(request.getPageNum(), request.getPageSize()), Wrappers.<UserInfo>lambdaQuery().orderByDesc(BaseEntity::getCreateTime));
    }

    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveUserBath(UserInfoRequest request) {
        List<UserInfo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(request, userInfo);
            userInfo.setUserName(request.getUserName() + UUID.randomUUID().toString());
            list.add(userInfo);
        }
        int insert = baseMapper.insertBatchSomeColumn(list);
        return String.valueOf(insert);
    }

    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateUserBath() {
        List<UserInfo> userInfoList = baseMapper.selectList(null);
        AtomicInteger i = new AtomicInteger(1);
        userInfoList.forEach(userInfo -> {
            userInfo.setUserName(userInfo.getUserName() + i);
            i.getAndIncrement();
        });
        int batch = baseMapper.updateBatch(userInfoList);
        return String.valueOf(batch);
    }
}
