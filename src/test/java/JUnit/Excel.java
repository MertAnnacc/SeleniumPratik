package JUnit;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel extends TestBase {
    @Test
    public void test01() throws IOException {
        String dosyaYolu = "src/test/java/JUnit/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(5);

        Cell cell = row.getCell(2);

        System.out.println(cell);
    }







}
