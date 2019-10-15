package com.wen.configuration;

import com.wen.interceptor.LoginRequiredInterceptor;
import com.wen.interceptor.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class WendaWebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired(required=false)
    @Qualifier("passportInterceptor")
    PassportInterceptor passportInterceptor;

    @Autowired(required=false)
    @Qualifier("loginRequiredInterceptor")
    LoginRequiredInterceptor loginRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportInterceptor);
        registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/user/*");
        registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/question/*");
        registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/search*");
        super.addInterceptors(registry);
    }
}
