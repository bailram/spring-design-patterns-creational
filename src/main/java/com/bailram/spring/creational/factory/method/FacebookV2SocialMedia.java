package com.bailram.spring.creational.factory.method;

import lombok.Getter;
import lombok.ToString;

@ToString
public class FacebookV2SocialMedia implements SocialMedia{
    @Getter
    private final String name = "FACEBOOK";
    @Getter
    private final String url = "https://web.facebook.com";
    @Getter
    private final SocialMediaType type = SocialMediaType.FACEBOOK;
}
