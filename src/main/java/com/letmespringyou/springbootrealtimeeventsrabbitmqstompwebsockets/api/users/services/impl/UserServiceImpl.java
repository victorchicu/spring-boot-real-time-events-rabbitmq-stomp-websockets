package com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.users.services.impl;

import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.users.objects.entity.User;
import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.oauth2.objects.OAuth2ExtendedProvider;
import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.users.repository.UserMongoRepository;
import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.users.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserMongoRepository userMongoRepository;

    public UserServiceImpl(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    public User saveUser(User user) {
        return userMongoRepository.save(user);
    }

    @Override
    public Optional<User> findUser(String email, OAuth2ExtendedProvider provider) {
        return userMongoRepository.findByEmailAndSocialProvider(email, provider);
    }
}
