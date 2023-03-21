package com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.oauth2.converters;

import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.oauth2.objects.OAuth2ExtendedProvider;
import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.users.objects.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.HashSet;
import java.util.Set;

public interface OAuth2UserConverter<T extends OAuth2User> {
    User convert(T oauth2User);

    OAuth2ExtendedProvider supportedProvider();

    default Set<GrantedAuthority> withDefaultAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorities;
    }
}
