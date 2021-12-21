package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.MobileUtils;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    @AndroidFindBy(id = "com.etsy.android:id/search_src_text")
    private MobileElement searchInput;

    @AndroidFindBy(accessibility = "Show Navigation Drawer")
    private MobileElement searchIcon;

    @AndroidFindBy(id = "com.etsy.android:id/listing_title")
    private List<MobileElement> searchResults;

    @AndroidFindBy(id = "com.etsy.android:id/query_text")
    private List<MobileElement> prepopulatedSearchResults;

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    public void searchFor(String text) {
        MobileUtils.waitFor(4000);
        MobileUtils.clickWithWait(searchIcon);

        MobileUtils.waitFor(2000);
        searchInput.sendKeys(text);

        MobileUtils.waitFor(2000);
        prepopulatedSearchResults.get(0).click();

        MobileUtils.waitFor(4000);
    }

    public List<String> getSearchResultTexts(){
        MobileUtils.waitFor(4000);
        return searchResults.stream().map(MobileElement::getText).collect(Collectors.toList());
    }
}
