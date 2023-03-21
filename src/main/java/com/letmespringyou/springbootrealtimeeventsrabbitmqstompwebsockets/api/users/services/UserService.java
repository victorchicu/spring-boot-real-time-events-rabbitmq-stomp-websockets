package com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.users.services;

import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.users.objects.entity.User;
import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.oauth2.objects.OAuth2ExtendedProvider;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findUser(String email, OAuth2ExtendedProvider provider);
}
