package com.wen.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author:HowieLee
 * @Date:1/5/2019
 * @Description:com.howie.wenda.aspect
 * @version:1.0
 */

/**
 * @Author HowieLee
 * @Description //TODO 使用了Spring中AOP的思想，面向切面的日志，在写日志的时候不影响主业务
 * @Date 20:33 1/14/2019
 * @Param logger
 * @return void
 **/

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Before("execution(* com.wen.controller.indexController.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        StringBuilder sc = new StringBuilder();
        for(Object arg : joinPoint.getArgs()){
            sc.append("arg" + arg.toString() +"|");
        }
        logger.info("before method" + sc.toString());
    }

    @After("execution(* com.wen.controller.indexController.*(..))")
    public void afterMethod(){
        logger.info("after method" + new Date());
    }
}
