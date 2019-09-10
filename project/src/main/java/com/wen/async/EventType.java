package com.wen.async;

/**
 * @Author:HowieLee
 * @Date:1/10/2019
 * @Description:com.howie.wen.async
 * @version:1.0
 */
/**
 * @Author HowieLee
 * @Description //TODO 定义实体的类型
 * @Date 20:48 1/14/2019
 * @Param 
 * @return 
 **/

public enum EventType {
    LIKE(0),
    COMMENT(1),
    LOGIN(2),
    MAIL(3),
    FOLLOW(4),
    UNFOLLOW(5);

    private int value;
    EventType(int value) { this.value = value; }
    public int getValue() { return value; }
}
