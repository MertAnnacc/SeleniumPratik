package First;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c1 {
    /* 1. Yeni bir package olusturalim : day01
2. Yeni bir class olusturalim : C03_GetMethods
3. Amazon sayfasina gidelim. https://www.amazon.com/
4. Sayfa basligini(title) yazdirin
5. Sayfa basliginin “Amazon” icerdigini test edin
6. Sayfa adresini(url) yazdirin
7. Sayfa url’inin “amazon” icerdigini test edin.
8. Sayfa handle degerini yazdirin
9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
10. Sayfayi kapatin
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver" , "src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        System.out.println(driver.getTitle());

        String expectedKelime = "Amazon";
        String actualResult = driver.getTitle();

        if (actualResult.contains(expectedKelime)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        System.out.println(driver.getCurrentUrl());

        String expectedUrlKelime = "amazon";
        String actualUrlKelime = driver.getCurrentUrl();

        if (actualUrlKelime.contains(expectedUrlKelime)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        System.out.println(driver.getWindowHandle());

        String expectedHtmlKod = "alisveris";
        String actualHtmlKod = driver.getPageSource();

        if (actualHtmlKod.contains(expectedHtmlKod)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }


        Thread.sleep(3000);

        driver.close();



    }
}
