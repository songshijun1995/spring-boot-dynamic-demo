package com.dynamic.dynamicdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dynamic.dynamicdemo.entities.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
