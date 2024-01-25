import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
public class ShoppingCartPage {
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By productName_Txt = By.xpath("(//td[@class='product-name']//a)[1]");
    private By productPrice_Txt = By.xpath("(//td[@class='product-price']//span)[1]");
    private By proceedToCheckout_Button = By.xpath("//div[@class='wc-proceed-to-checkout']//a");
    public ShoppingCartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate Thinking in HTML book added In Basket")
    public ShoppingCartPage validateTheBookDetails(String productName,String productPrice) {
        driver.verifyThat()
                .element(productName_Txt)
                .text()
                .isEqualTo(productName)
                .perform();
        driver.verifyThat()
                .element(productPrice_Txt)
                .text()
                .isEqualTo(productPrice)
                .perform();
        return this;
    }

    @Step("Click On Proceed To Checkout")
    public CheckoutPage ClickOnProceedToCheckout() {
        driver.element().click(proceedToCheckout_Button);
        return new CheckoutPage(driver);
    }
}
