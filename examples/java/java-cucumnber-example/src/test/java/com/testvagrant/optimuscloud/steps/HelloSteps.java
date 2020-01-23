package com.testvagrant.optimuscloud.steps;

import com.testvagrant.optimuscloud.entities.MobileDriverDetails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HelloSteps extends BaseSteps {

    public HelloSteps(Entity entity) {
        super(entity);
    }

    @Given("^i say hello$")
    public void iSayHello() throws InterruptedException {
        Thread.sleep(5000);
        String welcomeMessage = mobileDriver.findElement(By.id("welcome_message")).getText();
        Assert.assertEquals(
                welcomeMessage,
                "Welcome to Optimus!! You are all ready to experience Automation like never before."
        );
        Assert.assertTrue(false);
    }

    @Given("^i say welcome to optimus$")
    public void iSayWelcomeToOptimus() throws InterruptedException {
        Thread.sleep(5000);
        String welcomeMessage = mobileDriver.findElement(By.id("welcome_message")).getText();
        Assert.assertEquals(
                welcomeMessage,
                "Welcome to Optimus!! You are all ready to experience Automation like never before."
        );
    }
}
