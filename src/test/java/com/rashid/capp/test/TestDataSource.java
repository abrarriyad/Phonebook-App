package com.rashid.capp.test;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rashid.capp.config.SpringRootConfig;

import javax.sql.DataSource;

public class TestDataSource {
    public static void main(String[] args){
       
    	 ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
    	 System.out.println("line 1 executed");
         DataSource ds = ctx.getBean(DataSource.class);
         System.out.println("line 2 executed");
         JdbcTemplate jt = new JdbcTemplate(ds);
         System.out.println("line 3 executed");
         String sql="INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
         Object[] param = new Object[]{"Vikram", "9303580884", "vikram@ezeon.net", "Bhopal", "v", "v123"};
         jt.update(sql, param);
         System.out.println("------SQL executed-----");
    }
}
