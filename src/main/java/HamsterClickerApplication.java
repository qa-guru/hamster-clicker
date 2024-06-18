import com.codeborne.selenide.Configuration;
import drivers.MobileDriver;
import screens.HamsterScreen;

import static com.codeborne.selenide.Selenide.open;

public class HamsterClickerApplication {

    // Start app here
    public static void main(String[] args) {
        setup();
        new HamsterScreen().tapMorseCode("COIN");     // for morse (Improver Version)
        new HamsterScreen().tapManyTimes();         // for unlimited taps
    }


    // Here we config driver, boring!
    static void setup() {
        Configuration.browser = MobileDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 60000;
        open();
    }
}

