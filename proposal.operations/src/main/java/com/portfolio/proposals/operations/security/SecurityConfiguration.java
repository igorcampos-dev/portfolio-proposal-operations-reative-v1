package com.portfolio.proposals.operations.security;

import com.portfolio.proposals.operations.security.authentication.KeyAuthentication;
import com.portfolio.proposals.operations.security.filter.BasicAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class SecurityConfiguration {

    private final KeyAuthentication keyAuthentication;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> {
                    defaultRoutes().forEach( route -> request.requestMatchers(HttpMethod.GET, route).permitAll());
                    request.anyRequest().authenticated();
                })
                .addFilterBefore(new BasicAuthenticationFilter(keyAuthentication), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource () {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(List.of("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    public static List<String> defaultRoutes(){
        return List.of(
                "/swagger-ui.html",
                "/swagger-ui/swagger-initializer.js",
                "/swagger-ui/swagger-ui-standalone-preset.js",
                "/swagger-ui/swagger-ui.css",
                "/swagger-ui/swagger-ui-bundle.js",
                "/swagger-ui/favicon-32x32.png",
                "/v3/api-docs",
                "/v3/api-docs/swagger-config",
                "/swagger-ui/favicon-16x16.png",
                "/swagger-ui/index.css",
                "/swagger-ui/index.html"
        );
    }

}