package com.moldavets.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}123")
                .roles("EMPLOYEE")
                .build();
        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}123")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails katy = User.builder()
                .username("katy")
                .password("{noop}123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, susan, katy);
    }

}
