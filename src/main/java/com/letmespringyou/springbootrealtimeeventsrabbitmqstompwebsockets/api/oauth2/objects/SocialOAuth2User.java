package com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.oauth2.objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

import java.util.Collection;
import java.util.Objects;

public class SocialOAuth2User extends DefaultOidcUser {
    private final OAuth2ExtendedProvider provider;

    public SocialOAuth2User(Collection<? extends GrantedAuthority> authorities, OidcIdToken idToken, OAuth2ExtendedProvider provider) {
        super(authorities, idToken);
        this.provider = provider;
    }

    public SocialOAuth2User(Collection<? extends GrantedAuthority> authorities, OidcIdToken idToken, String nameAttributeKey, OAuth2ExtendedProvider provider) {
        super(authorities, idToken, nameAttributeKey);
        this.provider = provider;
    }

    public SocialOAuth2User(Collection<? extends GrantedAuthority> authorities, OidcIdToken idToken, OidcUserInfo userInfo, OAuth2ExtendedProvider provider) {
        super(authorities, idToken, userInfo);
        this.provider = provider;
    }

    public SocialOAuth2User(Collection<? extends GrantedAuthority> authorities, OidcIdToken idToken, OidcUserInfo userInfo, String nameAttributeKey, OAuth2ExtendedProvider provider) {
        super(authorities, idToken, userInfo, nameAttributeKey);
        this.provider = provider;
    }

    public OAuth2ExtendedProvider getProvider() {
        return provider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SocialOAuth2User that))
            return false;
        if (!super.equals(o))
            return false;
        return provider == that.provider;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), provider);
    }
}
