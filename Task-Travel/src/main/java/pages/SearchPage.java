package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.DriverFactory.getChromeDriver;
import static utils.DriverFactory.getWebDriverWait;

public class SearchPage {
    private final WebDriver driver = getChromeDriver();
    private final WebDriverWait wait = getWebDriverWait();

    private SearchPage() {

    }

    public static SearchPage getSearchPage() {
        return new SearchPage();
    }

    public void getFiltersAreaText() {
        WebElement filterSearch = driver.findElement(By.xpath("//div[@data-testid='little-search']"));
        wait.until(ExpectedConditions.visibilityOf(filterSearch));
    }
}
