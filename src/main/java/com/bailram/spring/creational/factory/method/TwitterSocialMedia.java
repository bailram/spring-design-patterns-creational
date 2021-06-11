package com.bailram.spring.creational.factory.method;

import lombok.Getter;
import lombok.ToString;

@ToString
public class TwitterSocialMedia implements SocialMedia {
    @Getter
    private final String name = "TWITTER";
    @Getter
    private final String url = "https://www.twitter.com";
    @Getter
    private final SocialMediaType type = SocialMediaType.TWITTER;
}
