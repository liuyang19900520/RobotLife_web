package com.liuyang19900520.config.cors;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;

/**
 * Created by liuyang on 2018/2/26
 */
public class MyCorsRegistration extends CorsRegistration {

    public MyCorsRegistration(String pathPattern) {
        super(pathPattern);
    }

    @Override
    public CorsConfiguration getCorsConfiguration() {
        return super.getCorsConfiguration();
    }
}
