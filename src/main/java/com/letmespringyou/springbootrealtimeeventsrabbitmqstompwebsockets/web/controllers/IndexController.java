package com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.web.controllers;

import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.dto.UserDto;
import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.entity.User;
import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.exceptions.OopsSomethingWentWrong;
import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.oauth2.SocialOAuth2User;
import com.letmespringyou.springbootrealtimeeventsrabbitmqstompwebsockets.api.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String index(@AuthenticationPrincipal SocialOAuth2User socialOAuth2User, Model model) {
        return userService.findUser(socialOAuth2User.getEmail(), socialOAuth2User.getProvider())
                .map(user -> {
                    UserDto userDto = toUserDto(user);
                    model.addAttribute("user", userDto);
                    return "index";
                })
                .orElseThrow(() -> new OopsSomethingWentWrong("Unable to find a user with email: " + socialOAuth2User.getEmail()));
    }

    private UserDto toUserDto(User user) {
        return UserDto.builder()
                .withId(user.getId())
                .withEmail(user.getEmail())
                .withPicture(user.getPicture())
                .withFullName(user.getFullName())
                .withPhoneNumber(user.getPhoneNumber())
                .withLocation(user.getLocation())
                .withProvider(user.getSocialProvider())
                .build();
    }
}
