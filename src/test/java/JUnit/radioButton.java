package JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class radioButton {
    //a. Verilen web sayfasına gidin.
    //https://facebook.com
    //b. Cookies’i kabul edin
    //c. Create an account buton’una basin
    //d. Radio button elementlerini locate edin ve size uygun olani secin

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver" , "src/drivers/chromedriver.exe");
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
        driver.get("https://facebook.com");
        Thread.sleep(3000);

        //b. Cookies’i kabul edin


        //c. Create an account buton’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        Thread.sleep(3000);

        //d. Radio button elementlerini locate edin ve size uygun olani secin
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        Thread.sleep(3000);











    }

}
