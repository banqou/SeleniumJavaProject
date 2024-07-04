package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    public WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Products')]")
    WebElement productLabel_xpath;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductLabelIsDisplayedInHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(productLabel_xpath));
        String productText= productLabel_xpath.getText();
        Assert.assertEquals(productText,"Products");
    }


}
