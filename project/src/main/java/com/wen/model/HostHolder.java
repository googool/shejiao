package com.wen.model;

import org.springframework.stereotype.Component;

/**
 * @Author:HowieLee
 * @Date:1/8/2019
 * @Description:com.howie.wen.interceptor
 * @version:1.0
 */

@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
