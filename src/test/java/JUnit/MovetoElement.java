package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class MovetoElement extends TestBase {

    @Test
    public void test01() {
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // 2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin  mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);

        WebElement accountLists = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountLists).perform();
        ReusableMethods.bekle(3);

        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        ReusableMethods.bekle(3);

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

        WebElement yourListText = driver.findElement(By.xpath("//div[@role='heading']"));

        Assert.assertTrue(yourListText.isDisplayed());


    }
}
