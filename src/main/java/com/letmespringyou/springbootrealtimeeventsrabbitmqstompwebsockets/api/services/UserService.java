package com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.services;

import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.entity.User;
import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.oauth2.OAuth2ExtendedProvider;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findUser(String email, OAuth2ExtendedProvider provider);
}
