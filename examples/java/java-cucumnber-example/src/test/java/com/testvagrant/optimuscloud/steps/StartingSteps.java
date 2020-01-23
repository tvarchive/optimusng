package com.testvagrant.optimuscloud.steps;

import com.testvagrant.monitor.requests.Device;
import com.testvagrant.optimuscloud.cucumber.io.DeviceCreator;
import com.testvagrant.optimuscloud.cucumber.io.ScenarioCreator;
import com.testvagrant.optimuscloud.cucumber.reporting.ScenarioReporter;
import com.testvagrant.optimuscloud.entities.MobileDriverDetails;
import com.testvagrant.optimuscloud.remote.OptimusCloudDriver;
import com.testvagrant.optimuscloud.remote.OptimusCloudManager;
import cucumber.runtime.io.Resource;
import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.FeatureParser;
import io.appium.java_client.AppiumDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map.Entry;

public class StartingSteps  {


    private Entity entity;
    private ScenarioReporter scenarioReporter;
    public StartingSteps(Entity entity) {
        this.entity = entity;
    }

    @Before
    public void setup(io.cucumber.core.api.Scenario cucumberScenario) throws MalformedURLException, URISyntaxException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appPackage", "com.testvagrant.hellooptimus");
        desiredCapabilities.setCapability("appActivity", "com.testvagrant.hellooptimus.MainActivity");
        desiredCapabilities.setCapability("app", "https://github.com/testvagrant/OptimusCloud/releases/download/v1/HelloOptimus.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("newCommandTimeout", "3600");
        MobileDriverDetails mobileDriverDetails = new OptimusCloudDriver().createDriver(desiredCapabilities);
        scenarioReporter = new ScenarioReporter(mobileDriverDetails, cucumberScenario);
        scenarioReporter.start();
        entity.setMobileDriverDetails(mobileDriverDetails);
    }


    @After
    public void tearDown(Scenario scenario) {
        scenarioReporter.stop();
        new OptimusCloudManager().releaseSession(entity.getMobileDriverDetails());
    }
}
