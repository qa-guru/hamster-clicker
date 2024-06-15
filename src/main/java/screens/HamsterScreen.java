package screens;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import utils.MorseUtils;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.RandomUtils.getRandomInt;

public class HamsterScreen {

    // Elements
    SelenideElement hamsterBody = $x("//android.widget.Button[@text='Hamster Kombat']"),
                    totalMoney = $x("//android.widget.TextView[@index='3']"); // todo fix locator


    void quickTap() {
        hamsterBody.click();
    }

    void longTap() {
        new Actions(getWebDriver())
                .clickAndHold(hamsterBody)
                .pause(800 + getRandomInt(10, 100))
                .release(hamsterBody)
                .perform();
    }

    // Here we make unlimited amount clicks / taps to hamster
    public void tapManyTimes() {
        while (true) {                                        // unlimited cycle
            quickTap();                                       // tap on hamster

            System.out.println(totalMoney.text());            // logging to console total money amount
            sleep(getRandomInt(10, 100)); // wait random time, milliseconds
        }
    }

    public void tapMorseCode(String morseCode) {
        for (char letter : morseCode.toCharArray()) {
            tapMorseLetter(String.valueOf(letter));
        }

        // todo realize command to pick up award
    }

    void tapMorseLetter(String letter) {
        String letterMorseCode = new MorseUtils().getLetterMorseCode(letter);

        for (char morseChar : letterMorseCode.toCharArray()) {
            switch (morseChar) {
                case '.':
                    quickTap();
                    break;
                case '-':
                    longTap();
                    break;
                default:
                    hardFart();
                    break;
            }
        }

        System.out.println(letter + ": " + letterMorseCode);
        sleep(1500 + getRandomInt(10, 100));
    }

    private void hardFart() {
        System.out.println("poo poooo pooo");
    }
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
