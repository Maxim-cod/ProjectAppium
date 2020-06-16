import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class HomeScreen {
    private static AndroidDriver<MobileElement> driver;
    @FindBy(xpath = "//android.widget.TextView[@text='איזור אישי']")
    MobileElement profileTab;
    @FindBy(xpath = "//android.widget.TextView[@text='גיפט קארד למותגי אופנה']")
    MobileElement pickCategory;
    @FindBy(xpath = "//android.widget.TextView[@text='RENUAR- רנואר']")
    MobileElement pickBuisness;
    @FindBy(id = "il.co.mintapp.buyme:id/priceEditText")
    MobileElement priceText;
    @FindBy(id = "il.co.mintapp.buyme:id/purchaseButton")
    MobileElement chooseGift;
    @FindBy(xpath = "//android.widget.TextView[@text='גיפט קארד לארוחת בוקר ובתי קפה']")
    MobileElement chooseCategory;



    //constructors
    public HomeScreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void profile() throws InterruptedException {
        Thread.sleep(2000);
        profileTab.click();
    }

    public void pickAGift() throws Exception {
        Thread.sleep(2000);
        pickCategory.click();
        pickBuisness.click();
        priceText.click();
        priceText.sendKeys(General.readFromFile("setPrice"));
        driver.hideKeyboard();
        chooseGift.click();

    }

    public void swipeByPercentage() {
        TouchAction touchAction = new TouchAction(driver);
        long seconds = 0;
        touchAction.press(element(chooseCategory))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }



}

