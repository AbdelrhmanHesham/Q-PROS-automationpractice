import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
public class CheckoutPage {
    private SHAFT.GUI.WebDriver driver;
    //Locators
    By billingDetailsTitle_Txt = By.xpath("(//div[@id='customer_details']//h3)[1]");

    By firstName_Txt = By.xpath("//div[@id='customer_details']//label[@for='billing_first_name']");
    public CheckoutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate Billing Details Form Displayed")
    public CheckoutPage validateTheBillingFormDisplayed(String billingDetailsTitle,String firstName) {
        driver.verifyThat()
                .element(billingDetailsTitle_Txt)
                .text()
                .isEqualTo(billingDetailsTitle)
                .perform();
        driver.verifyThat()
                .element(firstName_Txt)
                .text()
                .isEqualTo(firstName)
                .perform();
        return this;
    }
}
