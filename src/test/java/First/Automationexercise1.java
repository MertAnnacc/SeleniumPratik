package First;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Automationexercise1 {
    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver" , "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin


        List<WebElement> kategori =driver.findElements(By.className("panel-group category-products"));
        //4- Category bolumunde 3 element oldugunu test edin
        if (kategori.size()==3){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        Thread.sleep(3000);

        // 5- Category isimlerini yazdirin

        // 6- Sayfayi kapatin
        driver.close();
    }
}
