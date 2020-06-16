import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class giftCardToBreakFast {
    private static AndroidDriver<MobileElement> driver;
    @FindBy(id="il.co.mintapp.buyme:id/categoryName")
    MobileElement categoryName;
    @FindBy(id="il.co.mintapp.buyme:id/homeTab")
    MobileElement backToHomeScreen;

    //constructors
    public giftCardToBreakFast(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void setBackToHomePage (){
        backToHomeScreen.click();
    }

}
