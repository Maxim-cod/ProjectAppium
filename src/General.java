import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class General {
    private static AndroidDriver<MobileElement> driver;
    String imagesPath = ("C:\\Users\\MAXIM\\IdeaProjects\\ProjectAppium\\Screenshots");

    //xml file path
    public static String readFromFile(String KeyData) throws Exception {
        File xmlFile = new File("C:\\Users\\MAXIM\\IdeaProjects\\ProjectAppium\\configFile.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName(KeyData).item(0).getTextContent();
    }

    //function that return radio value
    public static void selectRadioButton(WebElement radio_label) {
        boolean selected_value = radio_label.isSelected();
        if (!selected_value) ;
        radio_label.click();
    }

    //function that return combo value
    public static void selectOptionsByValue(String value, WebElement element) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

}
