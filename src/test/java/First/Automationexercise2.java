package First;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Automationexercise2 {
    public static void main(String[] args) throws InterruptedException {

        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkler = driver.findElements(By.tagName("a"));
        if (linkler.size()==147){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        //// 4- Products linkine tiklayin
        driver.findElement(By.partialLinkText("Products")).click();
        Thread.sleep(2000);
        // 5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferYazisi =driver.findElement(By.id("sale_image"));

        if (specialOfferYazisi.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        Thread.sleep(2000);

        // 6- Sayfayi kapatin
        driver.close();

    }
}
