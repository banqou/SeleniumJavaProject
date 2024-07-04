package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutOverviewPage {
    public static WebDriver driver;
    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Overview')]")
    static WebElement checkoutOverview_xpath;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    static WebElement SauceLabsBackpack_xpath;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    static WebElement itemPrice_xpath;


    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    static WebElement total_xpath;

    @FindBy(id = "finish")
    static WebElement finishButton_id;

    @FindBy(id = "cancel")
    static WebElement cancelButton_id;

    @FindBy(xpath = "//button[contains(@id,'react-burger-menu-btn')]")
    static WebElement burgerMenuButton_id;

    @FindBy(xpath = "//a[contains(@id,'link')][@class='bm-item menu-item'][contains(.,'Logout')]")
    static WebElement logoutButton_id;

    public static void verifyCheckoutOverviewLabel() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(checkoutOverview_xpath));
        String checkoutOverviewText = checkoutOverview_xpath.getText();
        Assert.assertEquals(checkoutOverviewText, "Checkout: Overview");
    }

    public static void verifySauceLabsBackpackProductIsDisplayedInCheckOverviewPage() {
        String checkoutText = SauceLabsBackpack_xpath.getText();
        Assert.assertEquals(checkoutText, "Sauce Labs Backpack");
    }

    public static void verifyItemTotalPlusTax() {

        // Resolve Item Total
        float itemTotal = Float.parseFloat(itemPrice_xpath.getText().replace("Item total: $",""));
        float ItemTotalPlusTax= (float) (itemTotal+(itemTotal*0.08));

        // Resolve Total
        float Total = Float.parseFloat(total_xpath.getText().replace("Total: $",""));



      if(ItemTotalPlusTax==Total)

       {
           finishButton_id.click ();
       } else

        {
            cancelButton_id.click ();
        }
    }

    public static void clickFinishButton() {finishButton_id.click();}

    public static void clickCancelButton() {cancelButton_id.click();}

    public static void clickBurgerMenuButton(){burgerMenuButton_id.click();}

    public static void clickLogoutFromBurgerMenu() {logoutButton_id.click();}
}