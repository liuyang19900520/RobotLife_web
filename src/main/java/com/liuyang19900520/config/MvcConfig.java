package com.liuyang19900520.config;

import com.liuyang19900520.common.json.spring.JsonReturnHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * MVC 通用配置
 * 
 * @author Frank Zeng
 *
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public JsonReturnHandler jsonReturnHandler(){
        return new JsonReturnHandler();//初始化json过滤器
    }
    @Override
    public void addReturnValueHandlers(
            List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        returnValueHandlers.add(jsonReturnHandler());
    }
}
