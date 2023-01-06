package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class windowHandle {

            //https://the-internet.herokuapp.com/windows adresine gidin.
            //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
            //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
            //Click Here butonuna basın.
            //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            //Sayfadaki textin “New Window” olduğunu doğrulayın.
            //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedKelime = "Opening a new window";
        String actualKelime=driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();

        Assert.assertEquals(expectedKelime,actualKelime);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        String ilkWHDegeri = driver.getWindowHandle();

        Assert.assertEquals(expectedTitle , actualTitle);

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Thread.sleep(3000);

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        Set<String> tumWHDegerleriSeti = driver.getWindowHandles();

        String ikinciSayfaWHDegeri = "";
        for (String each:tumWHDegerleriSeti
             ) {
            if (!each.equals(ilkWHDegeri)){
                ikinciSayfaWHDegeri=each;
            }
        }

        driver.switchTo().window(ikinciSayfaWHDegeri);
        String expectedNewPageTitle = "New Window";
        String actualNewPageTitle = driver.getTitle();

        Assert.assertEquals(expectedNewPageTitle, actualNewPageTitle);

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedIkınciSayfaText = "New Window";
        String actualIkinciSayfaText = driver.findElement(By.xpath("(//*[text()='New Window'])[2]")).getText();

        Assert.assertEquals(expectedIkınciSayfaText, actualIkinciSayfaText);


        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın
        driver.switchTo().window(ilkWHDegeri);
        String expectedIlkSayfaTitle = "The Internet";
        String actualIlkSayfaTitle = driver.getTitle();

        Assert.assertEquals(expectedIlkSayfaTitle, actualIlkSayfaTitle);




        Thread.sleep(3000);













    }
}
