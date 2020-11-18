package com.yiming.hotel_manage.config;

import com.yiming.hotel_manage.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Locale;

@Configuration
public class DefaultViewConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("admin/admin_login");
        registry.addViewController("/adminmain.html").setViewName("admin/main");
    }



    //国际化配置
    @Bean
    public LocaleResolver localeResolver(){return new MyLocalResolver();  }
}
