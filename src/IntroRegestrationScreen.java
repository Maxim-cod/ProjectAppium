import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IntroRegestrationScreen {
    private static AndroidDriver<MobileElement> driver;
    @FindBy(id="il.co.mintapp.buyme:id/skipButton")
    MobileElement register;
    @FindBy(id="il.co.mintapp.buyme:id/googleButton")
    MobileElement googleLogin;
    @FindBy(id="com.google.android.gms:id/container")
    MobileElement chooseUser;





    //constructors
    public IntroRegestrationScreen(AndroidDriver<MobileElement> driver) {
        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void chooseGoogleAccount() throws InterruptedException {
        Thread.sleep(2000);
        register.click();
        Thread.sleep(2000);
        googleLogin.click();
        Thread.sleep(2000);
        chooseUser.click();
        Thread.sleep(2000);

    }



}
