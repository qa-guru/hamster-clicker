import com.codeborne.selenide.Configuration;
import drivers.MobileDriver;
import screens.HamsterScreen;

import static com.codeborne.selenide.Selenide.open;

public class HamsterClickerApplication {

    // Start app here
    public static void main(String[] args) {
        setup();
        new HamsterScreen().tapManyTimes();         // for unlimited taps
//        new HamsterScreen().tapMorseCode("GAMEFI");     // for morse (Improver Version)
//        new screens.Hamster().tapMorseCode();         // for morse (OLD BAD Version)
    }


    // Here we config driver, boring!
    static void setup() {
        Configuration.browser = MobileDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 60000;
        open();
    }
}

