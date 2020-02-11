package com.example.user.server.service.impl;

import com.example.user.server.dataobject.UserInfo;
import com.example.user.server.repository.UserInfoRepository;
import com.example.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By ChengHao On 2020/2/10
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
