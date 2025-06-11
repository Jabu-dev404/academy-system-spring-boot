package com.academy_system.maths.science_academy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetails = new JdbcUserDetailsManager(dataSource);
        userDetails.setUsersByUsernameQuery("select username,password,active from users where username = ?");
        userDetails.setAuthoritiesByUsernameQuery("select u.username,r.role from users u join roles r on u.user_id = r.user_id where u.username = ?");
        return userDetails;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(configure ->
                        configure
                                .requestMatchers("/api/**").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/api/capture-student").hasRole("STUDENT")
//                                .requestMatchers(HttpMethod.POST,"/signup").permitAll()
        ).formLogin(form ->
                form.disable()).httpBasic(basic->
                basic.disable()).sessionManagement(session->
                session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(1)
                        .maxSessionsPreventsLogin(true));

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception {

        return authenticationConfiguration.getAuthenticationManager();

    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource(){
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
//        corsConfiguration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
//        corsConfiguration.setAllowedHeaders(List.of("*"));
//        corsConfiguration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**",corsConfiguration);
//        return source;
//    }










}
