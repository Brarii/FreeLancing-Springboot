package com.example.newproj.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class securityconfig {
    private  final JWTFilter jf;

    private final AuthenticationProvider authentificationprovider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests().requestMatchers(
                        "/swagger-ui/**", "/swagger-ui.html",
                        "/v3/api-docs/**", "/swagger-resources/**",
                        "/webjars/**", "/auth/**")
                .permitAll()
                .requestMatchers("/freelancer/**").hasAuthority("FREELANCER")
                .requestMatchers("/client/**").hasAuthority("CLIENT")
                .requestMatchers("/**").hasRole("ADMIN")


                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy( SessionCreationPolicy.STATELESS )
                .and()
                .authenticationProvider(authentificationprovider)
                .addFilterBefore(jf, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}
