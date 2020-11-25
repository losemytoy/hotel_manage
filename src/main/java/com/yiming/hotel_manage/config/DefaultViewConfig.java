package com.yiming.hotel_manage.config;

import com.yiming.hotel_manage.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class DefaultViewConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("login/user_login");
        registry.addViewController("/admin").setViewName("login/admin_login");
        registry.addViewController("/adminmain.html").setViewName("admin/main");
        registry.addViewController("/login/user_login").setViewName("login/user_login");
        registry.addViewController("/login/admin_login").setViewName("login/admin_login");
    }



    //国际化配置
    @Bean
    public LocaleResolver localeResolver(){return new MyLocalResolver();  }
}
