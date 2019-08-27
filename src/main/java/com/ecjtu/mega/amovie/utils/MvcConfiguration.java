package com.ecjtu.mega.amovie.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @author mega
 * @date 2019-08-27 14:15
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private Myproperties myproperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + myproperties.getLocation() + File.separator);
    }
}
