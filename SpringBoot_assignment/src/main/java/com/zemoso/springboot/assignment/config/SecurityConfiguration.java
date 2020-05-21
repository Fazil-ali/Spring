package com.zemoso.springboot.assignment.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private  Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);


    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.jdbcAuthentication().dataSource(securityDataSource);
        logger.info(">>>>>>>>>>>In authentication Manager");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        logger.info(">>>>>>>>>> in httpSecurity");
        http.authorizeRequests()
                 .antMatchers("/products/home","/products/name/user").hasAnyRole("USER","MANAGER")
                    .antMatchers("/products/**").hasRole("MANAGER")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                        .loginPage("/login/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                    .and()
                        .logout().permitAll()
                    .and()
                        .exceptionHandling()
                        .accessDeniedPage("/login/access-denied");


    }

}