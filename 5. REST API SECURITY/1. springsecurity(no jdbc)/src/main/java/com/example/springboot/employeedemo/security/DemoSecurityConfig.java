package com.example.springboot.employeedemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    // adding users,passwords and roles, using in-memory authentication
    // InMemoryUserDetailsManager provide support for username/password based authentication
    // that is stored in memory.
    // User.builder() -> Builds the user to be added. At minimum the username, password, and authorities should provided.
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        // creating users
        // NOTE: {noop} is the encoding algorithm id, noop means password is stored as plain text
        // noop -> Useful for testing where working with plain text passwords may be preferred.
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }

    // RESTRICTING ACCESS BASED ON ROLES (employee cant see things which admin can)
    // SecurityFilterChain -> Defines a filter chain which is capable of being matched against an HttpServletRequest. in order to decide whether it applies to that request.
    // It's part of the Spring Security filter chain, which is a series of filters that process and manage security-related tasks for incoming HTTP requests.
    // konse filters use krne h security k lie
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // AUTHORIZATION RULES FOR DIFFERENT ROLES (EMPLOYEE,ADMIN,MANAGER)
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );
        // use HTTP basic Authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery
        // CSRF is for web apps with html forms, CSRF protection isnt required for stateless
        // REST API that use POST,PUT,DELETE
        http.csrf(csrf -> csrf.disable());
        return http.build();

        // now above in public InMemoryUserDetailsManager userDetailsManager(), we were giving
        // usersdetails by us, now here we'll just give data in database and simply use it here
        // no more hard-coding the userdetails, simply read users & roles from db
        // Spring Security will handle work of reading user,pass,roles from db as we'll follow their table schema

    }
}
// since we defined our users here, springboot wont use username/pass from app.pro file
// it'll use this user details manager

