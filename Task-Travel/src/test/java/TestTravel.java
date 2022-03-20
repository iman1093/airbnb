import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

import static pages.HomePage.getHomePage;
import static pages.SearchPage.getSearchPage;

public class TestTravel extends BaseTests {

    HomePage homePage = getHomePage();
    SearchPage searchPage = getSearchPage();

    @Test
    public void testFilters() {
        homePage.writeCityName("Rome")
                .selectCityLocation('1')
                .pickCheckInDate()
                .pickCheckOutDate()
                .clickOnAddGuests().addAdults(2)
                .addChildren(1)
                .search();
        searchPage.getFiltersAreaText();
    }
}
