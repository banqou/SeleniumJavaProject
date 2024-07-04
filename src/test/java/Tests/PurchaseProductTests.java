package Tests;

import Pages.CheckOutInformationPage;
import Pages.CheckoutOverviewPage;
import Pages.YourCartPage;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class PurchaseProductTests extends Base {



    public void enterUsernameTests() {
        loginPage.enterUsername(readFromExcel.username);
    }

    public void enterPasswordTests() {
        loginPage.enterPassword(readFromExcel.password);
        takeScreenshots.takeSnapShot(driver, "Login Screen");
    }

    @Test(dependsOnMethods = {"enterUsernameTests", "enterPasswordTests"})
    public void clickLoginTests() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginTests")
    public void verifyLoginSuccess() {
        homePage.verifyProductLabelIsDisplayedInHomePage();
        takeScreenshots.takeSnapShot(driver, "Home Screen");
    }

    @Test(dependsOnMethods = "verifyLoginSuccess")
    public void clickAddToCart() {
        productPage.clickAddToCart();
    }

    @Test(dependsOnMethods = "clickAddToCart")
    public void verifyAddedToCart() {
        productPage.verifyAddedToCart();
        takeScreenshots.takeSnapShot(driver, "Add To Cart");
    }

    @Test(dependsOnMethods = "verifyAddedToCart")
    public void clickNavigateToCart() {
        YourCartPage.clickNavigateToCart();
    }

    @Test(dependsOnMethods = "clickNavigateToCart")
    public void verifyYourCartLabelIsDisplayedInCartPage() {
        YourCartPage.verifyYourCartLabelIsDisplayedInCartPage();
        takeScreenshots.takeSnapShot(driver, "Your Cart");
    }

    @Test(dependsOnMethods = "verifyYourCartLabelIsDisplayedInCartPage")
    public void verifySauceLabsBackpackProductIsDisplayedInCartPage() {
        YourCartPage.verifySauceLabsBackpackProductIsDisplayedInCartPage();
        takeScreenshots.takeSnapShot(driver, "Sauce Labs Backpack");
    }

    @Test(dependsOnMethods = "verifySauceLabsBackpackProductIsDisplayedInCartPage")
    public void clickCheckout() {
        YourCartPage.clickCheckout();
        takeScreenshots.takeSnapShot(driver, "checkout");
    }

    @Test(dependsOnMethods = "clickCheckout")
    public void verifyCheckoutYourInformationPage() {
        CheckOutInformationPage.verifyCheckoutYourInformationPage();
        takeScreenshots.takeSnapShot(driver, "Checkout: Your Information");
    }
    @Test(dependsOnMethods = "verifyCheckoutYourInformationPage")
    public void enterFirstNameTests() {
        CheckOutInformationPage.enterFirstName(readFromExcel.firstName);
    }

    @Test(dependsOnMethods = "verifyCheckoutYourInformationPage")
    public void enterLastNameTests() {
        CheckOutInformationPage.enterLastName(readFromExcel.lastName);
    }

    @Test(dependsOnMethods = "verifyCheckoutYourInformationPage")
    public void enterPostalCodeTests() {
        CheckOutInformationPage.enterPostalCode(readFromExcel.postalCode);
        takeScreenshots.takeSnapShot(driver, "Details");
    }
    @Test(dependsOnMethods = {"enterFirstNameTests","enterLastNameTests","enterPostalCodeTests"})
    public void clickContinueButton() {
        CheckOutInformationPage.clickContinueButton();
    }
    @Test(dependsOnMethods = "clickContinueButton")
    public void CheckoutOverviewTests (){
        CheckoutOverviewPage.verifyCheckoutOverviewLabel();

    }
    @Test(dependsOnMethods = "CheckoutOverviewTests")
    public void verifySauceLabsBackpackProductIsDisplayedInCheckOverviewPage() {
        CheckoutOverviewPage.verifySauceLabsBackpackProductIsDisplayedInCheckOverviewPage();
        takeScreenshots.takeSnapShot(driver, "Check Out Overview");
    }

    @Test(dependsOnMethods = "verifySauceLabsBackpackProductIsDisplayedInCheckOverviewPage")
    public void verifyItemTotalPlusTax(){
        CheckoutOverviewPage.verifyItemTotalPlusTax();
        takeScreenshots.takeSnapShot(driver, "Total with Tax");
    }

    @Test(dependsOnMethods = "verifyItemTotalPlusTax")
    public void clickFinishButton(){
        CheckoutOverviewPage.clickFinishButton();
    }

    @Test(dependsOnMethods = "verifyItemTotalPlusTax")
    public void clickCancelButton(){
        CheckoutOverviewPage.clickCancelButton();
    }

    @Test(dependsOnMethods = {"clickFinishButton", "clickCancelButton"})
    public void clickBurgerMenuButton() {CheckoutOverviewPage.clickBurgerMenuButton();}

    @Test(dependsOnMethods = {"clickBurgerMenuButton"})
    public void clickLogoutFromBurgerMenu() {CheckoutOverviewPage.clickLogoutFromBurgerMenu ();}
}