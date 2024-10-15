package com.bank.config;

import jdk.jfr.Enabled;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebConfiguration {

    protected void http (HttpSecurity http) throws Exception{
        return ;
    }
}
