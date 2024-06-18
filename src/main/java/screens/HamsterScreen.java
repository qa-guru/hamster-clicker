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
    SelenideElement totalMoney = $x("//android.widget.TextView[@index='3']"), // todo fix locator
                    hamsterBody = $x("//android.widget.Button[@text='Hamster Kombat']"),
                    enterPerTapLabel = $x("//android.widget.TextView[@text='Earn per tap']"),
                    dailyCipherLabel = $x("//android.widget.TextView[@text='Daily cipher']"),
                    morsePrize = $x("//android.widget.Button[@text='Take the prize']");

    void quickTap() {
        hamsterBody.click();
//        System.out.println(totalMoney.text());
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

//            System.out.println(totalMoney.text());            // logging to console total money amount
//            sleep(getRandomInt(10, 100)); // wait random time, milliseconds
        }
    }

    public void tapMorseCode(String morseCode) {
        activateMorseMode();

        for (char letter : morseCode.toCharArray()) {
            tapMorseLetter(String.valueOf(letter));
        }

        takeMorsePrize();
        deactivateMorseMode();
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
        sleep(2000 + getRandomInt(10, 100));
    }

    private void takeMorsePrize() {
        morsePrize.click();
    }


    private void activateMorseMode() {
        if(!dailyCipherLabel.isDisplayed()) {
            enterPerTapLabel.click();
            enterPerTapLabel.click();
            enterPerTapLabel.click();
        }
    }

    private void deactivateMorseMode() {
        if(dailyCipherLabel.isDisplayed()) {
            enterPerTapLabel.click();
            enterPerTapLabel.click();
            enterPerTapLabel.click();
        }
    }

    private void hardFart() {
        System.out.println("poo poooo pooo");
    }
}