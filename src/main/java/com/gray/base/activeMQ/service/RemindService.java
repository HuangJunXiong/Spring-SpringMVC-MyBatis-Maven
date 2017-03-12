package com.gray.base.activeMQ.service;

import com.gray.user.entity.User;

/**
 * Created by lenovo on 2017/3/11.
 */
public interface RemindService {
    public void sendRegisterRemind(User user);
}
