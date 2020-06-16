import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfile {
    private static AndroidDriver<MobileElement> driver;
    @FindBy(id="il.co.mintapp.buyme:id/name")
    MobileElement profileText;
    @FindBy(id="il.co.mintapp.buyme:id/homeTab")
    MobileElement backToHomePage;
    @FindBy(xpath = "//android.widget.TextView[@text='על BUYME']")
    MobileElement settings;
    @FindBy(id="il.co.mintapp.buyme:id/contentText")
    MobileElement contentText;





    //constructors
    public MyProfile(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void setBackToHomePage (){
        backToHomePage.click();
    }
    public void settingScreen(){
        settings.click();
    }



}
