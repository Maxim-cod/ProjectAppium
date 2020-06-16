import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HowToSendScreen {
    AndroidDriver<MobileElement> driver;
    @FindBy(id ="il.co.mintapp.buyme:id/step2Text")
    MobileElement howToSendText;
    @FindBy(id="il.co.mintapp.buyme:id/nowRadioButton")
    MobileElement sendNow;
    @FindBy(className ="android.widget.EditText")
    MobileElement pickMail;
    @FindBy(id="il.co.mintapp.buyme:id/goNextButton")
    MobileElement nextButton;
    @FindBy(id="il.co.mintapp.buyme:id/step3Text")
    MobileElement lastStepText;






    //constructors
    public HowToSendScreen(AndroidDriver<MobileElement> driver) {
        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void fillingInformationStep2() throws Exception {
        boolean selected_value=sendNow.isSelected();
        if (!selected_value) ;
        sendNow.click();
        List list = driver.findElements(By.className("android.widget.CheckBox"));
        ((MobileElement) list.get(2)).click();
        pickMail.click();
        pickMail.sendKeys(General.readFromFile("pickMail"));
        driver.hideKeyboard();
        nextButton.click();





    }
}
