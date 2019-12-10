package com.rashid.capp.test;

import com.rashid.capp.config.SpringRootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class TestDataSource {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource dataSource = context.getBean(DataSource.class);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
        Object[] param = new Object[] {"Riyad","01784979245","rashid@gmail.com","Tangail","abrarriyad","123456"};

        jdbcTemplate.update(sql,param);
        System.out.println("------------SQl Executed -----------------------");

    }
}
