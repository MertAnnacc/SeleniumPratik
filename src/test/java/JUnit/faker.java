package JUnit;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class faker extends TestBase {

    @Test
    public void test01() {

        // facebook.com sayfasina gidin
        driver.get("https://www.facebook.com");


        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        // ilgili alanlari faker kutuphanesinden degerlerle doldurup
        WebElement firstnameKutusu = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String mailAdresi = faker.internet().emailAddress();

        actions.click(firstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("Oct")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();

        // kaydol butonuna basin
        WebElement signupButonu = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        signupButonu.click();
        // Kayit olamadiginizi test edin

        ReusableMethods.bekle(20);
        WebElement hataMesajElementi = driver.findElement(By.id("reg_error_inner"));

        Assert.assertTrue(hataMesajElementi.isDisplayed());


    }

}
