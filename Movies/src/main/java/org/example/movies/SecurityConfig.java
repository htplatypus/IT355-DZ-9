package org.example.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource; //nije promenjeno sa jakarta


/* WebSecurityConfigurerAdapter je deprecated i uklonjen u Spring Boot 3 = Spring 6 = Spring Security 6.
 Koristimo umesto SecurityFilterChain. Za JDBC auth je moguce koristiti default schema za auth:

                 .withDefaultSchema()  // Generates the default schema for USERS and AUTHORITIES
                .withUser("user")     // Adds a default user
                .password(passwordEncoder().encode("password"))
                .roles("USER");

 Ali default spring security schema nije kompatibilna sa MySQL, tako da kreiramo sami schema u /resources/userData.sql
 Testiramo autentifikaciju sa postman
 */


@Configuration
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .httpBasic();
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
