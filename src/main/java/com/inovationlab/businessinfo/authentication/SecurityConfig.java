package com.inovationlab.businessinfo.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/auth/test").permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                    .addFilterBefore(getSecurityFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public SecurityFilter getSecurityFilter(){
        return new SecurityFilter();
    }
}
