package org.allure.junit_videos;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoTest {

    private static RemoteWebDriver driver;

    @RegisterExtension
    VideoOnFailRule watcher = new VideoOnFailRule(driver);

    @BeforeAll
    public static void setupDriver() throws MalformedURLException {
        driver = Util.createDriver();
    }

    @Test
    public void openPage() {
        driver.get("https://en.wikipedia.org/wiki/Software_testing");

        assertFalse(driver.getTitle().contains("Software testing"));
    }

    @AfterAll
    public static void teardownDriver() {
        driver.quit();
    }


}
