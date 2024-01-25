import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CartCheckout {

    public SHAFT.GUI.WebDriver driver ;
    public JSONFileManager testData;

    @BeforeClass()
    public void beforeClass() {
        testData = new JSONFileManager("src/test/resources/testDataFiles/CartCheckout.json");
    }
    @BeforeMethod
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://practice.automationtesting.in/");
    }
    @AfterMethod(description = "Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @Test
    private void GC01(Method method) {
        new DashboardPage(driver).validateTheBookExistInDshboard(
                testData.getTestData(method.getName() + ".dashboardHeaderShopTxt"),
                testData.getTestData(method.getName() + ".bookNameTxt"),
                testData.getTestData(method.getName() + ".bookPriceTxt"));
    }
    @Test
    private void GC02(Method method) {
        new DashboardPage(driver).validateTheBookExistInDshboard(
                testData.getTestData(method.getName() + ".dashboardHeaderShopTxt"),
                testData.getTestData(method.getName() + ".bookNameTxt"),
                testData.getTestData(method.getName() + ".bookPriceTxt"))                .ClickOnAddToBasket()
                .ClickOnViewBasket();
        new ShoppingCartPage(driver).validateTheBookDetails(
                testData.getTestData(method.getName() + ".productNameTxt"),
                testData.getTestData(method.getName() + ".productPriceTxt"))  ;
    }
    @Test
    private void GC03(Method method) {
        new DashboardPage(driver).validateTheBookExistInDshboard(
                        testData.getTestData(method.getName() + ".dashboardHeaderShopTxt"),
                        testData.getTestData(method.getName() + ".bookNameTxt"),
                        testData.getTestData(method.getName() + ".bookPriceTxt"))                 .ClickOnAddToBasket()
                .ClickOnViewBasket();
        new ShoppingCartPage(driver).ClickOnProceedToCheckout();
        new CheckoutPage(driver).validateTheBillingFormDisplayed(
                testData.getTestData(method.getName() + ".billingDetailsTitleTxt"),
                testData.getTestData(method.getName() + ".firstNameTxt")) ;

    }
}
