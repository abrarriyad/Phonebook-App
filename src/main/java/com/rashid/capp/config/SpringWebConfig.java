package com.rashid.capp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/*
This is for web mvc layer
 */

@Configuration
@ComponentScan(basePackages = {"com.rashid.capp.*"})
@EnableWebMvc
public class SpringWebConfig extends WebMvcConfigurerAdapter {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*
        To access static resources like css,js files
         */
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
