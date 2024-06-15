package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class MobileDriver implements WebDriverProvider {

    private static final String PLATFORM_VERSION = "13.0";
    private static final String DEVICE_NAME = "Galaxy M52 5G";
    private static final String APPIUM_SERVER_URL = "http://localhost:4723/wd/hub";

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(PLATFORM_VERSION)
                .setDeviceName(DEVICE_NAME);

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private static URL getAppiumServerUrl() {
        try {
            return new URL(APPIUM_SERVER_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL: " + APPIUM_SERVER_URL, e);
        }
    }
}
