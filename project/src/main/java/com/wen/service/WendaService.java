package com.wen.service;

import org.springframework.stereotype.Service;

/**
 * @Author:HowieLee
 * @Date:1/6/2019
 * @Description:com.howie.wenda.service
 * @version:1.0
 */
@Service
public class WendaService {
    public String getMessage(int userId){
        return "Hello Message" + String.valueOf(userId);
    }
}
