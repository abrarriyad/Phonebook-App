package com.rashid.capp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
This class is for application layer
 */


@Configuration
@ComponentScan(basePackages = {"com.rashid.capp.dao","com.rashid.capp.service"})
public class SpringRootConfig {
    //TODO: Service, DAO, DataSource, Email-Sender etc or some other business class beans

	@Bean
    public BasicDataSource getBasicDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/capp_db?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setMaxTotal(2);
        ds.setInitialSize(1);
        ds.setTestOnBorrow(true);
        ds.setValidationQuery("SELECT 1");
        ds.setDefaultAutoCommit(true);
        return ds;
    }
	
 
}
