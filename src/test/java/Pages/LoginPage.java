package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;

    @FindBy(id = "user-name")
    WebElement username_id;

    @FindBy(id = "password")
    WebElement password_id;

    @FindBy(id = "login-button")
    WebElement loginButton_id;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enterUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(username_id));
        username_id.sendKeys(username);
        return this;
    }

    public void enterPassword(String password) {
        password_id.sendKeys(password);
    }

    public void clickLoginButton() {loginButton_id.click();
    }


}
