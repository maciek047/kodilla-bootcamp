package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User victor = new YGeneration("Victor Vector");
        User johnny = new Millenials("Johnny Silverhand");
        User judy = new ZGeneration("Judy Alvarez");

        //When
        String victorShare = victor.sharePost();
        System.out.println("Victor posted: " + victorShare);
        String johnnyShare = johnny.sharePost();
        System.out.println("Johnny posted: " + johnnyShare);
        String judyShare = judy.sharePost();
        System.out.println("Judy posted: " + judyShare);

        //Then
        Assert.assertEquals("[Twitter publisher] publishing tweet Y (your ripperdoc)", victorShare);
        Assert.assertEquals("[Facebook publisher] publishing post X (wake up samurai)", johnnyShare);
        Assert.assertEquals("[Snapchat publisher] publishing snap Z (braindance pro)", judyShare);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User johnny = new Millenials("Johnny Silverhand");

        //When
        String johnnyShare = johnny.sharePost();
        System.out.println("Johnny posted: " + johnnyShare);
        johnny.setSocialPublisher(new SnapchatPublisher());
        johnnyShare = johnny.sharePost();
        System.out.println("Johnny now posts: " + johnnyShare);

        //Then
        Assert.assertEquals("[Snapchat publisher] publishing snap Z (braindance pro)", johnnyShare);
    }
}

