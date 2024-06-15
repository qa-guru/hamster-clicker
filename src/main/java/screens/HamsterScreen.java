package screens;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import utils.MorseUtils;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HamsterScreen {

    // Elements
    SelenideElement hamsterBody = $x("//android.widget.Button[@text='Hamster Kombat']"),
                    totalMoney = $x("//android.widget.TextView[@index='3']"); // todo fix locator


    void quickTap() {
        hamsterBody.click();
    }

    void longTap() {
        Actions actions = new Actions(getWebDriver());
        actions.clickAndHold(hamsterBody)
                .pause(800 + new RandomUtils().getRandomInt(10, 100))
                .release(hamsterBody);
        actions.build().perform();
    }

    // Here we make unlimited amount clicks / taps to hamster
    public void tapManyTimes() {
        while (true) {                                        // unlimited cycle
            quickTap();                                       // tap on hamster
            System.out.println(totalMoney.text());            // logging to console total money amount
            sleep(new RandomUtils().getRandomInt(100, 1000)); // wait random time, milliseconds
        }
    }

    public void tapMorseCode(String morseCode) {
        for (int i = 0; i < morseCode.length(); i++) {
            tapMorseLetter(morseCode.split("")[i]);
        }

        // todo realize command to pick up award
    }

    void tapMorseLetter(String letter) {
        MorseUtils morseUtils = new MorseUtils();
        String letterMorseCode = morseUtils.getLetterMorseCode(letter);

        for (int i = 0; i < letterMorseCode.length(); i++) {
            String morseI = letterMorseCode.split("")[i];
            if (morseI.equals(".")) {
                quickTap();
            } else {
                longTap();
            }
        }

        System.out.println(letter + ": " + letterMorseCode);
        sleep(1500 + new RandomUtils().getRandomInt(10, 100));
    }


    // OLD VARIANT
    // Example for morse code  - - • • - - - • • • - • • •
    //                         G     A   M   E F       I
//    void tapMorseCode() {
//
//        // G
//        longTap();
//        longTap();
//        quickTap();
//        waitAfterLetter();
//        // A
//        quickTap();
//        longTap();
//        waitAfterLetter();
//        // M
//        longTap();
//        longTap();
//        waitAfterLetter();
//        // E
//        quickTap();
//        waitAfterLetter();
//        // F
//        quickTap();
//        quickTap();
//        longTap();
//        quickTap();
//        waitAfterLetter();
//        // I
//        quickTap();
//        quickTap();
//        waitAfterLetter();
//
//        // todo realize command to pick up award
//    }
//
//
//    void waitAfterLetter() {
//        sleep(1500 + new RandomUtils().getRandomInt(10, 100));
//    }
}
