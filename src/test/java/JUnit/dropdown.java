package JUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class dropdown {

    // ilgili ayarlari yapip
    // amazon anasayfaya gidin
    // arama kutusu yanindaki dropdown menuden book secin
    // arama kutusuna java yazdirip aramayi yapin
    // title'in java icerdigini test edin

    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver" ,"src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusu yanindaki dropdown menuden book secin
        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownMenu);

        select.selectByValue("search-alias=stripbooks-intl-ship");

        Thread.sleep(3000);

        // arama kutusuna java yazdirip aramayi yapin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java" + Keys.ENTER);

        Thread.sleep(3000);

        // title'in java icerdigini test edin
        String expectedKelime = "java";
        String actualKelime = driver.getTitle();

        Assert.assertTrue(actualKelime.contains(expectedKelime));


















    }

}
