package com.wen.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:HowieLee
 * @Date:1/7/2019
 * @Description:com.howie.wen.model
 * @version:1.0
 */
public class ViewObject {
    private Map<String,Object> objs = new HashMap<String,Object>();

    public void set(String key,Object value){
        objs.put(key,value);
    }

    public Object get(String key){
        return objs.get(key);
    }

}
