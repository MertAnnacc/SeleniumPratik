package JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Cookies extends TestBase {

    @Test
    public void test01() {

        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSeti= driver.manage().getCookies();
        int siraNo= 1;
        for (Cookie each :cookieSeti
             ) {
            System.out.println(siraNo + "-" + each);
            siraNo++;

        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSeti.size()>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookieDegeri = "USD";
        String actualCookieDegeri = "";

        for (Cookie each: cookieSeti
             ) {
            if (each.getName().equals("i18n-prefs")){
                actualCookieDegeri = each.getValue();
            }

        }

        Assert.assertEquals(expectedCookieDegeri,actualCookieDegeri);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun
        Cookie myCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(myCookie);

        cookieSeti = driver.manage().getCookies();
        siraNo =1;
        for (Cookie each : cookieSeti
             ) {
            System.out.println(siraNo + "-" + cookieSeti);
            siraNo++;

        }
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        expectedCookieDegeri="cikolatali";
        int cikolataliCookieSayisi=0;

        for (Cookie each:cookieSeti
        ) {

            if (each.getName().equals("en sevdigim cookie")){
                cikolataliCookieSayisi++;
            }

        }
        Assert.assertTrue(cikolataliCookieSayisi>0);
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        cookieSeti= driver.manage().getCookies();
        int skinCookieSayisi=0;
        for (Cookie eachCookie:cookieSeti
        ) {

            if (eachCookie.getName().equals("skin")){
                skinCookieSayisi++;
            }

        }

        Assert.assertEquals(0,skinCookieSayisi);

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSeti = driver.manage().getCookies();

        Assert.assertEquals(0,cookieSeti.size());


    }
}
