package com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.exceptions;

public class OopsSomethingWentWrong extends RuntimeException {
    public OopsSomethingWentWrong(String message) {
        super(message);
    }
}