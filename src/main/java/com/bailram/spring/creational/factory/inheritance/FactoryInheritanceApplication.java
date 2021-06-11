package com.bailram.spring.creational.factory.inheritance;

import com.bailram.spring.creational.factory.method.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class FactoryInheritanceApplication {
    @Bean
    @Scope("prototype")
    public SocialMedia socialMediaFacebook() {
        return new FacebookV2SocialMedia();
    }

    @Bean
    @Scope("prototype")
    public SocialMedia socialMediaTwitter() {
        return new TwitterSocialMedia();
    }

    @Bean
    @Scope("prototype")
    public SocialMedia socialMediaTiktok() {
        return new TiktokSocialMedia();
    }

    @Bean
    @Scope("prototype")
    public SocialMedia socialMediaInstagram() {
        return new InstagramSocialMedia();
    }
}
