import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
public class DashboardPage {
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By dashboard_HeaderShop_Txt = By.id("menu-item-40");
    private By bookName_Txt = By.xpath("//div[@id='text-22-sub_row_1-0-2-1-0']//h3");
    private By bookPrice_Txt = By.xpath("//div[@id='text-22-sub_row_1-0-2-1-0']//ins//span[@class='woocommerce-Price-amount amount']");
    private By addToBasket_Button = By.xpath("//a[@data-product_id='163']");
    private By viewBasket_Button = By.xpath("//div[@id='text-22-sub_row_1-0-2-1-0']//a[@title='View Basket']");
    public DashboardPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate Thinking in HTML book exist in Dashboard")
    public DashboardPage validateTheBookExistInDshboard(String dashboard_HeaderShop,
                                                        String bookName,String bookPrice) {
        driver.verifyThat()
                .element(dashboard_HeaderShop_Txt)
                .text()
                .isEqualTo(dashboard_HeaderShop)
                .perform();
        driver.verifyThat()
                .element(bookName_Txt)
                .text()
                .isEqualTo(bookName)
                .perform();
        driver.verifyThat()
                .element(bookPrice_Txt)
                .text()
                .isEqualTo(bookPrice)
                .perform();
        return this;
    }

    @Step("Add the book to Basket")
    public DashboardPage ClickOnAddToBasket() {
        driver.element().click(addToBasket_Button);
        return this;
    }
    @Step("Click On View Basket")
    public ShoppingCartPage ClickOnViewBasket() {
        driver.element().click(viewBasket_Button);
        return new ShoppingCartPage(driver);
    }

}