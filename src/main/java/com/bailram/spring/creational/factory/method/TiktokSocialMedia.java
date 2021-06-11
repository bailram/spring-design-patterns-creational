package com.bailram.spring.creational.factory.method;

import lombok.Getter;
import lombok.ToString;

@ToString
public class TiktokSocialMedia implements SocialMedia {
    @Getter
    private final String name = "TIKTOK";
    @Getter
    private final String url = "https://www.titkok.com";
    @Getter
    private final SocialMediaType type = SocialMediaType.TIKTOK;
}
