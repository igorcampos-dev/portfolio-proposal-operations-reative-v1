package com.portfolio.proposals.operations.security.authentication;

import com.portfolio.proposals.operations.repository.AccessTokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class KeyAuthentication {

    private final AccessTokenRepository accessTokenRepository;

    public void authenticate (HttpServletRequest request){
        var context =  Optional.ofNullable(request.getHeader("x-api-key"))
                .map(key -> {
                    if (!keyExists(key))
                        throw new BadCredentialsException("Chave de acesso inválida");
                    return new ApiKeyAuthentication(key, List.of(new SimpleGrantedAuthority("ADMIN")));
                })
                .orElseThrow(() -> new BadCredentialsException("Requisição não autorizada"));

        SecurityContextHolder.getContext().setAuthentication(context);
    }

    private boolean keyExists(String key) {
        return accessTokenRepository.findAll().stream()
                .anyMatch(token -> key.equals(token.getKey()));
    }

}
