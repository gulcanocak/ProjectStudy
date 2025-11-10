package Testinium.Pages;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class dataReadFromXlsx {
    public String readData(int x, int y) throws IOException {
        String text1;
        FileInputStream fis = new FileInputStream("src/test/java/Utilies/data.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        text1 = String.valueOf(workbook.getSheet("Sayfa1").getRow(x).getCell(y)).toString();
        return text1;
    }
}
