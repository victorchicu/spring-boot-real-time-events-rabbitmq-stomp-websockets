package com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.oauth2;

import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.entity.User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class FacebookOAuth2UserConverter implements OAuth2UserConverter<OAuth2User> {
    @Override
    public User convert(OAuth2User oauth2User) {
        return User.builder()
                .withEmail(oauth2User.getAttribute("email"))
                .withFullName(oauth2User.getAttribute("name"))
                .withSocialProvider(supportedProvider())
                .withGrantedAuthorities(withDefaultAuthorities())
                .build();
    }

    @Override
    public OAuth2ExtendedProvider supportedProvider() {
        return OAuth2ExtendedProvider.FACEBOOK;
    }
}
