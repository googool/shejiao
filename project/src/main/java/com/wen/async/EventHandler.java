package com.wen.async;

import java.util.List;

public interface EventHandler {

    void doHandle(EventModel model);
    //用来注册自己，宣布自己关注什么event
    List<EventType> getSupportEventTypes();
}
