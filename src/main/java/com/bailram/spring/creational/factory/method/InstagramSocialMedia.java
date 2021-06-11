package com.bailram.spring.creational.factory.method;

import lombok.Getter;
import lombok.ToString;

@ToString
public class InstagramSocialMedia implements SocialMedia {
    @Getter
    private final String name = "INSTAGRAM";
    @Getter
    private final String url = "https://www.instagram.com";
    @Getter
    private final SocialMediaType type = SocialMediaType.INSTAGRAM;
}
