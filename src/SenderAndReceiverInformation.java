import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SenderAndReceiverInformation {
    AndroidDriver<MobileElement> driver;
    @FindBy(id="il.co.mintapp.buyme:id/main_toolbar_title")
    MobileElement fromWhoTheGiftText;
    @FindBy(id="il.co.mintapp.buyme:id/toEditText")
    MobileElement receiverName;
    @FindBy(xpath ="//android.widget.TextView[@text='מהו סוג האירוע? נעזור לכם לכתוב ברכה']")
    MobileElement whatKindOfEvent;
    @FindBy(xpath ="//android.widget.CheckedTextView[@text='תודה']")
    MobileElement chooseEvent;
    @FindBy(id="il.co.mintapp.buyme:id/blessEditText")
    MobileElement enterBlessing;
    @FindBy(id="il.co.mintapp.buyme:id/goNextButton")
    MobileElement nextButton;



   //constructors
    public SenderAndReceiverInformation(AndroidDriver<MobileElement> driver) {
        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void fillTheInformation() throws Exception {
        Thread.sleep(2000);
        receiverName.click();
        receiverName.sendKeys(General.readFromFile("receiverName"));
        driver.hideKeyboard();
        Thread.sleep(2000);
        whatKindOfEvent.click();
        Thread.sleep(2000);
        chooseEvent.click();
        enterBlessing.clear();
        enterBlessing.sendKeys(General.readFromFile("enterBlessing"));
        driver.hideKeyboard();
        nextButton.click();




    }
}
