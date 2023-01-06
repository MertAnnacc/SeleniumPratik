package First;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
       //3- Browseri tam sayfa yapin
       //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
       //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedKelime = "Spend less";
        String actualKelime =driver.getTitle();
        if (actualKelime.contains(expectedKelime)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
       //6- Gift Cards sekmesine basin
        driver.findElement(By.xpath("(//a[@class='nav-a  '])[3] ")).click();
        Thread.sleep(3000);

       //7- Birthday butonuna basin
       driver.findElement(By.xpath("//a[@aria-label='Birthday']")).click();
        Thread.sleep(3000);


        //8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();
        Thread.sleep(3000);


        //9- Gift card details’den 25 $’i secin
        WebElement urunUcreti =driver.findElement(By.xpath("//button[@value='25']"));
        urunUcreti.click();
        Thread.sleep(3000);


        //10-Urun ucretinin 25$ oldugunu test edin
        String expectedUcret ="$25";
        String actualUcret = urunUcreti.getText();

        if (actualUcret.equals(expectedUcret)){
            System.out.println("Gift card ucret Testi PASSED");

        }else {
            System.out.println("Gift card ucret Testi FAILED");
        }
        Thread.sleep(3000);


        //11-Sayfayi kapatin

        driver.close();

    }
}
