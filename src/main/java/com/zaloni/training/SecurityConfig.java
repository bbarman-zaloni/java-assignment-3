package com.zaloni.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      String admin = new BCryptPasswordEncoder().encode("admin");
      auth.inMemoryAuthentication().withUser("admin").password(admin).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .antMatchers("/**").access("hasRole('ROLE_ADMIN')")
        .and().formLogin();
    }

    @Bean public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
