package com.example;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class BaseClassA {
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static Actions ac;
    public static String attribute;

    public static void setProperty(String driver) {
        switch (driver) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        "E:\\JAVA\\ECLIPSE\\Excel_Write\\src\\test\\resources\\Resources\\chromedriver.exe");
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver",
                        "E:\\JAVA\\ECLIPSE\\Excel_Write\\src\\test\\resources\\Resources\\msedgedriver.exe");
                break;
            default:
                System.out.println("The driver is not feasible");

        }
    }

    public static void browserLaunch(String browser) {
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("The browser is not feasible");
        }
    }

    public static void waitTime(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    public static void winMaximize() {
        driver.manage().window().maximize();
    }

    public static void get(String url) {
        driver.get(url);
    }

    public static void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public static void sendKeys(WebElement element, String data) {
        element.sendKeys(data);
    }

    public static void click(WebElement element) {
        element.click();
    }

    public static void selectByIndex(WebElement dropdown, int i) {
        Select sc = new Select(dropdown);
        sc.selectByIndex(i);
    }

    public static void selectByValue(WebElement dropdown, String val) {
        Select sc = new Select(dropdown);
        sc.selectByValue(val);
    }

    public static void selectByVisibleText(WebElement dropdown, String val) {
        Select sc = new Select(dropdown);
        sc.selectByVisibleText(val);
    }

    public static void isSelected(WebElement element) {
        boolean selected = element.isSelected();
        System.out.println(selected);
    }

    public static void alertAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void alertDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public static void alertSendKeys_Accept(String value) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
        alert.accept();
    }

    public static void check_Displayed_Enabled_Selected(WebElement element) {
        boolean displayed = element.isDisplayed();
        boolean enabled = element.isEnabled();
        boolean selected = element.isSelected();
        System.out.println("Displayed:" + displayed);
        System.out.println("Enabled:" + enabled);
        System.out.println("Selected:" + selected);
    }

    public static void acMoveToElement(WebElement element) {
        ac = new Actions(driver);
        ac.moveToElement(element).build().perform();
    }

    public static void acClick(WebElement element) {
        ac = new Actions(driver);
        ac.click(element).perform();
    }

    public static void acContextClick(WebElement element) {
        ac = new Actions(driver);
        ac.contextClick(element).perform();
    }

    public static void acDoubleClick(WebElement element) {
        ac = new Actions(driver);
        ac.doubleClick(element).perform();
    }

    public static void dragAndDrop(WebElement draggable, WebElement droppable) {
        ac = new Actions(driver);
        ac.dragAndDrop(draggable, droppable).perform();
    }

    public static void robot_SendKeys_Down(WebElement element, String name, int count)
            throws AWTException, InterruptedException {
        Robot rb = new Robot();
        element.sendKeys(name);
        for (int i = 1; i <= count; i++) {
            rb.keyPress(KeyEvent.VK_DOWN);
            rb.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(2000);
        }
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void robot_RightClick_Down(WebElement element, int count) throws AWTException, InterruptedException {
        ac = new Actions(driver);
        ac.contextClick(element).perform();
        Robot rb = new Robot();
        for (int i = 1; i <= count; i++) {
            rb.keyPress(KeyEvent.VK_DOWN);
            rb.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(2000);
        }
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }

    // public static void radioButtonClick(WebElement element) {
    // element.click();
    // }

    public static String excelRead_reuse(int r, int c) {
        String value = null;
        try {
            File f = new File("E:\\JAVA\\ECLIPSE\\JunitProject\\src\\test\\resources\\TestData\\Book2.xlsx");
            FileInputStream fis = new FileInputStream(f);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet("Sheet1");
            Row row = sheet.getRow(r);
            Cell cell = row.getCell(c);
            int cellType = cell.getCellType();
            if (cellType == 1) {
                value = cell.getStringCellValue();
                // System.out.println(value);
            } else if (cellType == 0) {
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date dateVal = cell.getDateCellValue();
                    SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
                    value = sim.format(dateVal);
                    // System.out.println(value);
                } else {
                    double d = cell.getNumericCellValue();
                    int val = (int) d;
                    value = String.valueOf(val);
                    // System.out.println(value);
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return value;
    }

    public static void excelWrite_Reuse(int i, int j, String data) {

        try {
            File f = new File("E:\\JAVA\\ECLIPSE\\JunitProject\\src\\test\\resources\\TestData\\Book2.xlsx");
            FileInputStream fis = new FileInputStream(f);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet("Sheet1");
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(j);
            cell.setCellValue(data);
            FileOutputStream fos = new FileOutputStream(f);
            wb.write(fos);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String property_Reuse(String data) {
        String value = "null";
        try {
            File f = new File("E:\\JAVA\\ECLIPSE\\JunitProject\\src\\test\\resources\\TestData\\config.properties");
            FileReader read = new FileReader(f);
            Properties prop = new Properties();
            prop.load(read);
            value = prop.getProperty(data);
            System.out.println(value);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return value;

    }

    public static void implicitWait() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    // public static void explicitWait1(WebElement element) {
    // WebDriverWait wait = new WebDriverWait(driver, 15);
    // wait.until(ExpectedConditions.invisibilityOf(element)));
    // }

    public static void getAttribute(WebElement element, String value) {

        attribute = element.getAttribute(value);
        System.out.println(attribute);

    }

    public static void getScreenshot(String name) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File path = new File("E:\\PROJECT\\Screenshots\\" + name);
        FileHandler.copy(src, path);
    }

    public static void scrollBy(int i, int j) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(i,j)");
    }

    public static void excel_Write(String value) {
        try {
            File f = new File("E:\\JAVA\\ECLIPSE\\JunitProject\\src\\test\\resources\\TestData\\Book2.xlsx");
            FileInputStream fis = new FileInputStream(f);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.createSheet("SheetA");
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue(value);
            FileOutputStream fos = new FileOutputStream(f);
            wb.write(fos);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
