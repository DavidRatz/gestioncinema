package be.technifutur.user.services.impl;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import be.technifutur.sharedclass.forms.LoginForm;
import be.technifutur.user.configs.JwtProperties;
import be.technifutur.user.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authManager;

    private final JwtProperties properties;

    public LoginServiceImpl(JwtProperties properties) {
        this.properties = properties;
    }

    @Override
    public String login(LoginForm form){
        Authentication authentication = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());

        try{
            authentication = authManager.authenticate(authentication);
        }
        catch(AuthenticationException ex){
            System.out.println(ex.getMessage());
        }

        return properties.getPrefix() + JWT.create()
            .withSubject(form.getUsername())
            .withIssuedAt(new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + properties.getExpires()))
            .withClaim("roles", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
            .sign(Algorithm.HMAC512(properties.getSecret()));        
    }
}
