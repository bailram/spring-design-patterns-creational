package com.bailram.spring.creational.factory.method;

import lombok.Getter;
import lombok.ToString;

@ToString
@Deprecated
public class FacebookSocialMedia implements SocialMedia {
    @Getter
    private final String name = "FACEBOOK";
    @Getter
    private final String url = "https://www.facebook.com";
    @Getter
    private final SocialMediaType type = SocialMediaType.FACEBOOK;
}
