package org.allure.junit_videos;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.nio.file.Path;
import java.nio.file.Paths;


public class VideoOnFailRule implements TestWatcher {

    protected RemoteWebDriver driver;

    public VideoOnFailRule(RemoteWebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void testFailed (ExtensionContext context, Throwable throwable) {
        Util.attachVideo(driver);
    }

}