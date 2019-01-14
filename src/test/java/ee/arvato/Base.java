package ee.arvato;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class Base {
    public WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        String username = "vasja15";
        String accessKey = "p1xPp5ZEYg5ugao95ZMd";
        String server = "hub-cloud.browserstack.com";

        //browserStack - Google Nexus 9
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("os_version", "5.1");
        capability.setCapability("device", "Google Nexus 9");
        capability.setCapability("real_mobile", "true");
        capability.setBrowserName("chrome");
        capability.setVersion("71.0.3578");
        capability.setCapability("browserstack.debug", "true");

        driver = new RemoteWebDriver(new URL("http://" + username + ":" + accessKey + "@" + server + "/wd/hub"), capability);
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void openPageFromUrl(String expectedUrl) {
        open(expectedUrl);
        assertThat(expectedUrl).isEqualTo(url());
    }

    public void checkCrmCustomerServicePage(String logo_name,String header_text,String button_name) {
        $(byXpath(String.format("//img[contains(@src,'%s')]", logo_name))).scrollTo().exists();
        $(byXpath("//div[@class='crm-content']/h3")).scrollTo().shouldHave(exactText(header_text));
        $(byXpath("//div[@class='crm-content']/div/a[@class='btn']")).scrollTo().shouldHave(exactText(button_name));
    }

    public void checkCrmOpenPositionsPage(int amount, List<String> positions, String page_header) {
        $(byXpath("//div[@class='open-positions-content']/h3")).scrollTo().shouldHave(exactText(page_header));
        assertThat($$(byXpath("//div[contains(@class,'type-job_listing')]"))).hasSize(amount);
        assertThat($$(byXpath("//div[contains(@class,'type-job_listing')]")).texts()).containsExactlyInAnyOrder((String[]) positions.toArray(new String[amount]));
    }
}
