package com.project0.esprit.security;

import com.project0.esprit.utils.*;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private final UserDetailsService userDetailsService;
    private final JwtTokenUtils jwtTokenUtil;
    private final String tokenHeader = "Authorization";

    public JwtAuthorizationTokenFilter(UserDetailsService userDetailsService, JwtTokenUtils jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        LOG.info("processing authentication for '{}'", request.getRequestURL());
        final String requestHeader = request.getHeader(this.tokenHeader);
        String username = null;
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);
            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e) {
                LOG.error("an error occured during getting username from token", e);
            } catch (ExpiredJwtException e) {
                LOG.warn("the token is expired and not valid anymore", e);
            }
        } else {
            LOG.info("no token was included with: " + request.getRequestURL());
        }

        LOG.info("checking authentication for user '{}'", username);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Get fresh user info from db, You could also store the information only in the token and read it from it.
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
           
            // For simple validation it is completely sufficient to just check the token integrity. You don't have to call the database compellingly. 
            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                LOG.info("authorizated user '{}', setting security context", username);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}
