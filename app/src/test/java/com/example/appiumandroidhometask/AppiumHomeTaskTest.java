package com.example.appiumandroidhometask;

import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class AppiumHomeTaskTest {

    private final static String APP = "C:\\Apps\\EPAM_Connect.apk";
    private final static String APPIUM = "http://localhost:4723/wd/hub";
    private AndroidDriver androidDriver;

    @Before
    public void setUp () throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("androidInstallTimeout", "180000");
        capabilities.setCapability("app", APP);
        androidDriver = new AndroidDriver(new URL(APPIUM), capabilities);
    }

    @After
    public void tearDown() {
        androidDriver.quit();
    }

    @Test
    public void checkOfSignInFrameTest() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/content"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId("Next")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Skip\"]"))).click();
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId("Log In")));
        WebElement signupButton = androidDriver.findElement(new MobileBy.ByAccessibilityId("Sign Up"));

        assertTrue(loginButton.isDisplayed());
        assertTrue(signupButton.isDisplayed());


    }
}