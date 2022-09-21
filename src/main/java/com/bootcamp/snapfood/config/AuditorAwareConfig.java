package com.bootcamp.snapfood.config;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

public class AuditorAwareConfig implements AuditorAware<String> {
    @Autowired
    private HttpServletRequest request;

    @Override
    public Optional<String> getCurrentAuditor() {
        AccessToken accessToken = this.getKeycloakToken(request.getUserPrincipal());
        String userName = accessToken.getPreferredUsername();

        return Optional.ofNullable(userName);
    }

    private AccessToken getKeycloakToken(Principal principal) {
        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) principal;
        return keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();
    }
}