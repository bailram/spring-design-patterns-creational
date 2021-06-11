package com.bailram.spring.creational.factory.inheritance;

import com.bailram.spring.creational.factory.method.SocialMedia;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FactoryInheritanceApplication.class)
class FactoryInheritanceApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testFactoryInheritanceApplication() {
        SocialMedia facebook = applicationContext.getBean("socialMediaFacebook", SocialMedia.class);
        SocialMedia twitter = applicationContext.getBean("socialMediaTwitter", SocialMedia.class);
        SocialMedia tiktok = applicationContext.getBean("socialMediaTiktok", SocialMedia.class);
        SocialMedia instagram = applicationContext.getBean("socialMediaInstagram", SocialMedia.class);

        System.out.println(facebook);
        System.out.println(twitter);
        System.out.println(tiktok);
        System.out.println(instagram);
    }
}