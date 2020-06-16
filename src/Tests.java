import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

//putting tests in order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
    //create class object
    IntroRegestrationScreen introRegestrationScreen=new IntroRegestrationScreen(driver);
    MyProfile myProfile=new MyProfile(driver);
    HomeScreen homeScreen=new HomeScreen(driver);
    SenderAndReceiverInformation senderAndReceiverInformation=new SenderAndReceiverInformation(driver);
    HowToSendScreen howToSendScreen=new HowToSendScreen(driver);
    giftCardToBreakFast giftCardToBreakFast=new giftCardToBreakFast(driver);
    GiftCardToSpa giftCardToSpa=new GiftCardToSpa(driver);
    String imagesPath = ("C:\\Users\\MAXIM\\IdeaProjects\\ProjectAppium\\Screenshots");
    private static ExtentReports extent;
    private static ExtentTest maximTests;
    private static AndroidDriver<MobileElement> driver;


    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void setUp() throws Exception {
        //path to test logs
        extent = new ExtentReports(General.readFromFile("reportPath"));
        //path to report config
        extent.loadConfig(new File("C:\\Users\\MAXIM\\IdeaProjects\\ProjectAppium\\reportConfig.xml"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("appPackage", General.readFromFile("appPackage"));
        capabilities.setCapability("appActivity", General.readFromFile("appActivity"));

        capabilities.setCapability("newCommandTimeout", 120);

        //ip server
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);

        //waiting function
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    //starting test 01
    @Test
    public void test01_introAndRegistration() throws Exception {
        maximTests = extent.startTest(name.getMethodName());
        maximTests.log(LogStatus.INFO, "start test ");
        Thread.sleep(2000);
        //choose google account
        introRegestrationScreen.chooseGoogleAccount();
        Thread.sleep(2000);
        //enter to your profile
        homeScreen.profile();
        String myProfileText = myProfile.profileText.getText();
        String expectedProfileText = General.readFromFile("myFirstName");
        //checking if the name of my profile is correct
        try {
            assertEquals(expectedProfileText, myProfileText);
            maximTests.log(LogStatus.PASS, "the profile name will be Maxim ");
            maximTests.log(LogStatus.INFO, "details", maximTests.addScreenCapture(takeScreenShot(imagesPath + "\\" + System.currentTimeMillis())));
        } catch (AssertionError error) {
            maximTests.log(LogStatus.FAIL, "the profile name is not Maxim " + error);
        }
        myProfile.setBackToHomePage();
        maximTests.log(LogStatus.INFO,"end of test " + name.getMethodName());

    }
      //end of test01

      //start of test 02
        @Test
        public void test02_HomeScreen () throws Exception {
        maximTests = extent.startTest(name.getMethodName());
        maximTests.log(LogStatus.INFO, "start test ");
        Thread.sleep(2000);
        //choosing gift card
        homeScreen.pickAGift();
        Thread.sleep(2000);
        senderAndReceiverInformation=new SenderAndReceiverInformation(driver);
        String fromWhoTheGiftTxt=senderAndReceiverInformation.fromWhoTheGiftText.getText();
        String expectedText=General.readFromFile("fromWhoTheGift");
        //checking if the from who the gift text is exist in from who the gift page
        try{
            assertEquals(expectedText,fromWhoTheGiftTxt);
            maximTests.log(LogStatus.PASS,"the text is equals ");
            maximTests.log(LogStatus.INFO, "details", maximTests.addScreenCapture(takeScreenShot(imagesPath + "\\" + System.currentTimeMillis())));

        }catch (AssertionError error){
            maximTests.log(LogStatus.FAIL,"the text is not equals " + error);
        }
            maximTests.log(LogStatus.INFO,"end of test " + name.getMethodName());

    }
    //end of test 02

    //start of test 03
    @Test
    public void test03_SenderReceiver() throws Exception {
        maximTests = extent.startTest(name.getMethodName());
        maximTests.log(LogStatus.INFO, "start test ");
        Thread.sleep(2000);
        //scrolling to element text "Maxim" using scroll to element function
        String text = "Maxim";
        MobileElement el = driver.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector()).setAsVerticalList().scrollIntoView("
                        + "new UiSelector().text(\""+text+"\"));"));
        //filling the information in sender and receiver page
        senderAndReceiverInformation.fillTheInformation();
        Thread.sleep(2000);
        howToSendScreen=new HowToSendScreen(driver);
        String howToSendTxt=howToSendScreen.howToSendText.getText();
        String expectedTxt=General.readFromFile("howToSendText");
        //checking if the how to send text is exist in how to sent page
        try {
            assertEquals(expectedTxt,howToSendTxt);
            maximTests.log(LogStatus.PASS,"the text is equals ");
            maximTests.log(LogStatus.INFO, "details", maximTests.addScreenCapture(takeScreenShot(imagesPath + "\\" + System.currentTimeMillis())));
        }catch (AssertionError error){
            maximTests.log(LogStatus.FAIL,"the text is not equals " + error);
        }
        maximTests.log(LogStatus.INFO,"end of test " + name.getMethodName());

    }
    //end of test 03

    //start of test 04
    @Test
    public void test04_HowToSendScreen() throws Exception {
        maximTests = extent.startTest(name.getMethodName());
        maximTests.log(LogStatus.INFO, "start test ");
        Thread.sleep(2000);
        //fill the information in step 2 page
        howToSendScreen.fillingInformationStep2();
        Thread.sleep(2000);
        howToSendScreen=new HowToSendScreen(driver);
        String paymentTxt=howToSendScreen.lastStepText.getText();
        String expectedTxt=General.readFromFile("paymentText");
        //checking if the last step text is exist in page payment
        try{
            assertEquals(expectedTxt,paymentTxt);
            maximTests.log(LogStatus.PASS,"the result is equals ");
            maximTests.log(LogStatus.INFO, "details", maximTests.addScreenCapture(takeScreenShot(imagesPath + "\\" + System.currentTimeMillis())));

        }catch (AssertionError error){
            maximTests.log(LogStatus.FAIL,"the result is not equals " + error);
        }
        maximTests.log(LogStatus.INFO,"end of test " + name.getMethodName());
        driver.closeApp();
        //closing app
    }
    //end of test 04

//    start of test 05
    @Test
    public void test05_chooseCategoryScreen() throws Exception {
        //launching the app again
        driver.launchApp();
        maximTests = extent.startTest(name.getMethodName());
        maximTests.log(LogStatus.INFO, "start test ");
        Thread.sleep(2000);
        //swipe to category using swipe function
        homeScreen.swipeByPercentage();
        String categoryNameText=giftCardToBreakFast.categoryName.getText();
        String expectedText=General.readFromFile("categoryText");
        //checking if the category text is exist
        try{
            assertEquals(expectedText,categoryNameText);
            maximTests.log(LogStatus.PASS,"the text will be gift card to breakfast ");
            maximTests.log(LogStatus.INFO, "details", maximTests.addScreenCapture(takeScreenShot(imagesPath + "\\" + System.currentTimeMillis())));
        }catch (AssertionError error){
            maximTests.log(LogStatus.FAIL,"the text wont be gift card to breakfast " + error);
        }

        Thread.sleep(1000);
        //pressing back to home page
        giftCardToBreakFast.setBackToHomePage();
        maximTests.log(LogStatus.INFO,"end of test " + name.getMethodName());
        //closing the app again
        driver.closeApp();
    }
//    end of test 05

    //stat of test 06
    @Test
    public void test06_settingScreen() throws Exception {
        //launching the app again
        driver.launchApp();
        maximTests = extent.startTest(name.getMethodName());
        maximTests.log(LogStatus.INFO, "start test ");
        Thread.sleep(1000);
        //enter to profile page
        homeScreen.profile();
        //enter to settings in profile tab
        myProfile.settingScreen();
        String contentText=myProfile.contentText.getText();
        String expectedContentText=General.readFromFile("buyMeText");
        try{
            //checking if the buy me text is exist in settings page
            assertEquals(expectedContentText,contentText);
            maximTests.log(LogStatus.PASS,"the text will be shown ");
            maximTests.log(LogStatus.INFO, "details", maximTests.addScreenCapture(takeScreenShot(imagesPath + "\\" + System.currentTimeMillis())));
            maximTests.log(LogStatus.INFO,contentText);
        }catch (AssertionError error){
            maximTests.log(LogStatus.FAIL,"the text wont be shown " + error);
        }
        maximTests.log(LogStatus.INFO,"end of test " + name.getMethodName());
    }
    //end of test 06




    @After
    public void afterTest() {
        extent.endTest(maximTests);
    }

    //Run once at the end of the test
    @AfterClass
    public static void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.closeApp();
        extent.flush();
   }
   //take a screen shot function
    public static String takeScreenShot(String imagesPath) {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(imagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return imagesPath + ".png";
    }




}

