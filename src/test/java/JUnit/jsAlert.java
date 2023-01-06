package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class jsAlert {


    // Gerekli ayarlamalari yapip
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 3 test method'u olusturup her method'da bir JsAlert'e basin
    // Ilgili method'lari kullanin
    // 1.alert'e tiklayalim
    // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
    // OK tusuna basip alert'i kapatalim
    // 2.alert'e tiklayalim
    // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
    // 3.alert'e tiklayalim
    // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
    // Cikan sonuc yazisinin Abdullah icerdigini test edelim
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);

        //1.alert'e tiklayalim
        WebElement js1 = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        js1.click();


        // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
        String expectedKelime = "I am a JS Alert";
        String actualKelime = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedKelime,actualKelime);

        // OK tusuna basip alert'i kapatalim
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @Test
    public void test02() throws InterruptedException {
        // 2.alert'e tiklayalim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();

        String expectedResult = "You clicked: Cancel";
        String actualResult = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void test03() throws InterruptedException {
        // 3.alert'e tiklayalim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
        // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().sendKeys("Abdullah");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        // Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedResult = "Abdullah";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actualResult.contains(expectedResult));

    }


}
