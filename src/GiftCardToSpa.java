import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class GiftCardToSpa {
    private static AndroidDriver<MobileElement> driver;
    @FindBy(xpath ="//android.widget.TextView[@text='מלון אדמונד']")
    MobileElement hotelAdmond;

    //constructors
    public GiftCardToSpa(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void expensiveGift(){
        TouchAction touchAction = new TouchAction(driver);
        long seconds = 0;
        touchAction.press(point(26,372))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
//        hotelAdmond.click();

    }
}

