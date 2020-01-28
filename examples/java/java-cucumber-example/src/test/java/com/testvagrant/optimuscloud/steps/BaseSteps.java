package com.testvagrant.optimuscloud.steps;

import com.testvagrant.optimuscloud.entities.MobileDriverDetails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;

public class BaseSteps {

    protected AppiumDriver mobileDriver;

    public BaseSteps(Entity entity) {
        this.mobileDriver = (AppiumDriver) entity.getMobileDriverDetails().getMobileDriver();
    }
}
