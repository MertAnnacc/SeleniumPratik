package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class DragAndDrop extends TestBase {

    @Test
    public void test01() {

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);

        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();
        ReusableMethods.bekle(3);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement DropHereYazisi = driver.findElement(By.xpath("//*[text()='Dropped!']"));

        Assert.assertTrue(DropHereYazisi.isDisplayed());


    }

}
