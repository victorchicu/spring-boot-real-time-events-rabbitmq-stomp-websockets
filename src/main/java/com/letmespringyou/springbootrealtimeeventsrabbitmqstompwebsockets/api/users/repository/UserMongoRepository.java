package com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.users.repository;

import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.users.objects.entity.User;
import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.oauth2.objects.OAuth2ExtendedProvider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String> {
    Optional<User> findByEmailAndSocialProvider(String email, OAuth2ExtendedProvider provider);
}
