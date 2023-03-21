package com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.websockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class ExtendedWebSocketMessageBrokerConfigurer implements WebSocketMessageBrokerConfigurer {
    private static final String[] STOMP_ENDPOINT_PATHS = {"/websocket"};
    private static final String[] APPLICATION_DESTINATION_PREFIXES = {"/app"};
    private static final String[] STOMP_BROKER_RELAY_DESTINATION_PREFIXES = {"/topic"};

    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        messageBrokerRegistry
                .setApplicationDestinationPrefixes(APPLICATION_DESTINATION_PREFIXES)
                .enableStompBrokerRelay(STOMP_BROKER_RELAY_DESTINATION_PREFIXES)
                .setRelayHost("localhost")
                .setRelayPort(61613);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry
                .addEndpoint(STOMP_ENDPOINT_PATHS)
                .withSockJS();
    }
}
