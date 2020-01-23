package com.testvagrant.sample;

import com.testvagrant.optimuscloud.dashboard.testng.OptimusCloudConstants;
import com.testvagrant.optimuscloud.entities.MobileDriverDetails;
import com.testvagrant.optimuscloud.entities.SessionInfo;
import com.testvagrant.optimuscloud.remote.OptimusCloudDriver;
import com.testvagrant.optimuscloud.remote.OptimusCloudManager;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class MobileTest {

    protected MobileDriver mobileDriver;
    protected MobileDriverDetails mobileDriverDetails;
    private SessionInfo sessionInfo;
    private OptimusCloudManager optimusCloudManager;

    public MobileTest() {
        this.optimusCloudManager = new OptimusCloudManager();
    }

    @BeforeMethod
    public void setupDriver(ITestContext iTestContext) throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appPackage", "com.testvagrant.hellooptimus");
        desiredCapabilities.setCapability("appActivity", "com.testvagrant.hellooptimus.MainActivity");
        desiredCapabilities.setCapability("app", "https://github.com/testvagrant/OptimusCloud/releases/download/v1/HelloOptimus.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("newCommandTimeout", "3600");
        mobileDriverDetails = new OptimusCloudDriver().createDriver(desiredCapabilities);
        iTestContext.setAttribute(OptimusCloudConstants.MOBILE_DRIVER, mobileDriverDetails);
        mobileDriver = mobileDriverDetails.getMobileDriver();
    }

    @Test
    public void shouldDisplayWelcomeMessage() {
        String welcomeMessage = mobileDriver.findElement(By.id("welcome_message")).getText();
        Assert.assertEquals(
                welcomeMessage,
                "Welcome to Optimus!! You are all ready to experience Automation like never before."
        );
    }

    @Test
    public void shouldDisplayWelcomeMessage1() {
        String welcomeMessage = mobileDriver.findElement(By.id("welcome_message")).getText();
        Assert.assertEquals(
                welcomeMessage,
                "Welcome to Optimus!! You are all ready to experience Automation like never before."
        );
    }

    @Test
    public void shouldDisplayWelcomeMessage2() throws InterruptedException {
        String welcomeMessage = mobileDriver.findElement(By.id("welcome_message")).getText();
        Thread.sleep(5000);
        Assert.assertEquals(
                welcomeMessage,
                "Welcome to Optimus!! You are all ready to experience Automation like never before."
        );
    }

    @Test
    public void shouldDisplayWelcomeMessage3() {
        String welcomeMessage = mobileDriver.findElement(By.id("welcome_message")).getText();
        Assert.assertEquals(
                welcomeMessage,
                "Welcome to Optimus!! You are all ready to experience Automation like never before."
        );
    }

    @AfterMethod
    public void tearDownDriver() {
        optimusCloudManager.releaseSession(mobileDriverDetails);
    }


}
