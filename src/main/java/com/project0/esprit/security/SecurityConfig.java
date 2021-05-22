/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project0.esprit.security;

import com.project0.esprit.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
    
    @Bean
    public JwtAuthorizationTokenFilter getJwtFilter() {
        return new JwtAuthorizationTokenFilter(userDetailsService(), jwtTokenUtils);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Autowired
    JwtAuthorizationTokenFilter authenticationTokenFilter;
    
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private UserAuthService userService;
    
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	http.cors()
        .and()
    .headers()
        .frameOptions().disable()
        .and()
    .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")  // user admin  
                .antMatchers("/delivery").access("hasRole('DELIVERY_MAN')") //user delivery 
                
                //.antMatchers("/api/duty/**").hasAnyRole("ADMIN")
                .antMatchers("/",
                		"/api/**",
                		"/api2/**",
                		"/mail/**",
                		"/paypal/**",
                        "/api1/polls/**",
                        "/api1/user/**",
                        "/api1/auth/login/**",
                        "/api/cat", "/api/products1", "/logout","/",
                        "/api/colisEnattent",
                        "/api1/auth/register/**",
                        "/gs-guide-websocket/info",
                        "/gs-guide-websocket/**",
                        "/webjars/jquery/jquery.min.map",
                        "/app.js",
                       "/socket",
                       "/socket/**",
                       "/socket/",
                       "/socket/info/**",
                       "/socket/info/",
                       "/Facture/**",
                       "/Panier/**",
                       
                       "/apiyes/**",
                       
                     //   "/ws",
                        "/pub/**",
                        
                        "/Commande/**",
                        
                       /* 
                        
                  
                        
                    
                        
                        "/app/**",
                        */
                        "/chat/**",
                        
                        
                        "/webjars/stomp-websocket/stomp.min.js"
                        
                )
                .permitAll()
                .anyRequest()
                .authenticated()
                
                .and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.and().
                ;
        
        //http.authorizeRequests().antMatchers().permitAll();
        
        //http.authorizeRequests();

      
        http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        
        web.ignoring().antMatchers(
                HttpMethod.GET,
                "/",
                "/*.html",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/**/*.ttf",
                "/**/*.png",
                "/**/*.json",
                "/**/*.gif",
                "/**/*.woff2",
                "/swagger-ui.html/**",
                "/swagger-resources/**",
                "/v2/api-docs/**")
                .and()
                .ignoring()
                .antMatchers("/h2-console/**/**");
    }

}
