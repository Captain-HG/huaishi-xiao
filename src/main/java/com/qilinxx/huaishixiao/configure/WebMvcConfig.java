package com.qilinxx.huaishixiao.configure;


import com.qilinxx.huaishixiao.utils.UploadUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ UploadUtil.getUploadFilePath()+"upload/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
