package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.DriverFactory.getChromeDriver;
import static utils.DriverFactory.getWebDriverWait;

public class HomePage {
    private final WebDriver driver = getChromeDriver();
    private final WebDriverWait wait = getWebDriverWait();

    private HomePage() {

    }

    public static HomePage getHomePage() {
        return new HomePage();
    }

    public HomePage writeCityName(String cityName) {
        WebElement location = driver.findElement(By.xpath("//input[@data-testid='structured-search-input-field-query']"));
        wait.until(ExpectedConditions.visibilityOf(location));
        location.clear();
        location.sendKeys(cityName);
        return this;
    }

    /**
     * @param id starts at '0'
     */
    public HomePage selectCityLocation(char id) {
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//div[@data-index=" + id + "]")))
                .click();
        return this;
    }

    public HomePage pickCheckInDate() {
        WebElement pickIn = driver.findElement(By.xpath("//div[@data-testid='datepicker-day-2022-03-27']"));
        wait.until(ExpectedConditions.visibilityOf(pickIn)).click();
        return this;
    }

    public HomePage pickCheckOutDate() {
        WebElement pickOut = driver.findElement(By.xpath("//div[@data-testid='datepicker-day-2022-04-02']"));
        wait.until(ExpectedConditions.visibilityOf(pickOut)).click();
        return this;
    }

    public HomePage clickOnAddGuests() {
        WebElement addButton = driver.findElement(By.xpath("//div[@data-testid='structured-search-input-field-guests-button']"));
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
        return this;
    }

    /**
     * @param numOfAdults starts at 1
     */
    public HomePage addAdults(int numOfAdults) {
        WebElement increaseButton = driver.findElement(By.xpath("//button[@data-testid='stepper-adults-increase-button']"));
        wait.until(ExpectedConditions.visibilityOf(increaseButton));
        for (int i = 0; i < numOfAdults; i++) {
            increaseButton.click();
        }
        return this;
    }

    public HomePage addChildren(int numOfChildren) {
        WebElement increaseButton = driver.findElement(By.xpath("//button[@data-testid='stepper-children-increase-button']"));
        wait.until(ExpectedConditions.visibilityOf(increaseButton));
        for (int i = 0; i < numOfChildren; i++) {
            increaseButton.click();
        }
        return this;
    }

    public void search() {
        WebElement searchButton = driver.findElement(By.cssSelector("._1dbgthhp"));
        searchButton.click();
    }

//    /**
//     * @param week starts at 1
//     */
//    private String getCheckDate(int week){
//        LocalDateTime dateTime = LocalDateTime.now().plusWeeks(week);
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
//        String formatter = dateFormat.format(dateTime);
//        System.out.println(formatter);
//        return formatter;
//    }
}
