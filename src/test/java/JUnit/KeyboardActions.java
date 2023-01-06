package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class KeyboardActions extends TestBase {

    @Test
    public void test01() {
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(driver);

        actions
                .click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();



        // 4- aramanin gerceklestigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='s-desktop-width-max sg-row-align-items-center sg-row']"));

        String expectedKelime="Samsung a71";
        String actualSonucYazisi= sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        ReusableMethods.bekle(3);
    }
}
