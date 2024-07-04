package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromExcel {

    String testData_dir="./src/te+st/java/TestData/data.xlsx";
    FileInputStream fis = new FileInputStream(testData_dir);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    XSSFSheet loginDetailSheet = workbook.getSheet("Login Details");

    XSSFSheet userInformationSheet = workbook.getSheet("User Information");

    public String username = loginDetailSheet.getRow(1).getCell(0).getStringCellValue();
    public String password = loginDetailSheet.getRow(1).getCell(1).getStringCellValue();

    public String firstName = userInformationSheet.getRow(1).getCell(0).getStringCellValue();
    public String lastName = userInformationSheet.getRow(1).getCell(1).getStringCellValue();
    public String postalCode = userInformationSheet.getRow(1).getCell(2).getStringCellValue();

    public ReadFromExcel() throws IOException {
    }
}
