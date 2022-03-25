package com.spring.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
public class AppConfig {

    @Bean(name = "securityDataSource")
    public DataSource securityDataSource(){

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/customerdb");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("P@ssword");
        return driverManagerDataSource;
    }
}
