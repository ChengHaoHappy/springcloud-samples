package com.example.user.server.service;

import com.example.user.server.dataobject.UserInfo;

/**
 * Created By ChengHao On 2020/2/10
 */
public interface UserService {

    /**
     * 通过openId查询用户信息
     * @param openId
     * @return
     */
    UserInfo findByOpenid(String openId);
}
