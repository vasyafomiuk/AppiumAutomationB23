package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {

    @AndroidFindBy(id = "com.etsy.android:id/edit_username")
    private MobileElement username;

    @AndroidFindBy(id = "com.etsy.android:id/edit_password")
    private MobileElement password;

    @AndroidFindBy(id = "com.etsy.android:id/button_signin")
    private MobileElement signInBtn;

    @AndroidFindBy(id = "com.etsy.android:id/btn_link")
    private MobileElement getStartedBtn;

    public LoginPage (){
        //PageFactory - we use it to enable @FindBy
        //AppiumFieldDecorator - we use it to enable mobile annotations: @AndroidFindBy, iOSXCUITFindBy  ...
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }
}
