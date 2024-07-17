package com.portfolio.proposals.operations.security.filter;

import com.portfolio.proposals.operations.security.SecurityConfiguration;
import com.portfolio.proposals.operations.security.authentication.KeyAuthentication;
import com.portfolio.proposals.operations.security.response.FilterErrorResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class BasicAuthenticationFilter extends OncePerRequestFilter {

    private final KeyAuthentication keyAuthentication;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain){


        try {
            keyAuthentication.authenticate(request);
            filterChain.doFilter(request, response);
        } catch (Exception e){
            FilterErrorResponse.getError(response, e, request);
        }

    }

    @Override
    protected boolean shouldNotFilter(@NonNull HttpServletRequest request) {
        return SecurityConfiguration.defaultRoutes()
                                    .stream()
                                    .anyMatch(route -> request.getServletPath().contains(route));
    }

}
