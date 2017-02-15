package com.doh.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 *
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends
    AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;



    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("acme")
            .secret("acmesecret")
            .authorities("ROLE_TRUSTED_CLIENT")
            .authorizedGrantTypes("implicit", "authorization_code", "refresh_token", "password")
            .accessTokenValiditySeconds(600)
            .scopes("openid")
            .autoApprove(true).and()
            .withClient("doh")
            .secret("dohsecret")
            .authorities("ROLE_TRUSTED_CLIENT")
            .authorizedGrantTypes("implicit", "authorization_code", "refresh_token", "password")
            .accessTokenValiditySeconds(600)
            .scopes("openid")
            .autoApprove(true);
    }




 


}
