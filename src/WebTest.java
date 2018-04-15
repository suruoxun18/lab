//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class WebTest {
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","/Users/apple/Downloads/chromedriver");//chromedriveræœ�åŠ¡åœ°å�€
//        WebDriver driver = new ChromeDriver(); //æ–°å»ºä¸€ä¸ªWebDriver çš„å¯¹è±¡ï¼Œä½†æ˜¯new çš„æ˜¯FirefoxDriverçš„é©±åŠ¨
//        driver.get("https://psych.liebes.top/st");//æ‰“å¼€æŒ‡å®šçš„ç½‘ç«™
//        //driver.findElement(By.id("kw")).sendKeys(new  String[] {"hello"});//æ‰¾åˆ°kwå…ƒç´ çš„idï¼Œç„¶å�Žè¾“å…¥hello
//        //driver.findElement(By.id("su")).click(); //ç‚¹å‡»æŒ‰æ‰­
//        try {
//            /**
//             * WebDriverè‡ªå¸¦äº†ä¸€ä¸ªæ™ºèƒ½ç­‰å¾…çš„æ–¹æ³•ã€‚
//            dr.manage().timeouts().implicitlyWait(arg0, arg1ï¼‰ï¼›
//            Arg0ï¼šç­‰å¾…çš„æ—¶é—´é•¿åº¦ï¼Œint ç±»åž‹ ï¼›
//            Arg1ï¼šç­‰å¾…æ—¶é—´çš„å�•ä½� TimeUnit.SECONDS ä¸€èˆ¬ç”¨ç§’ä½œä¸ºå�•ä½�ã€‚
//             */
//            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);        
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        /**
//         * dr.quit()å’Œdr.close()éƒ½å�¯ä»¥é€€å‡ºæµ�è§ˆå™¨,ç®€å�•çš„è¯´ä¸€ä¸‹ä¸¤è€…çš„åŒºåˆ«ï¼šç¬¬ä¸€ä¸ªcloseï¼Œ
//         * å¦‚æžœæ‰“å¼€äº†å¤šä¸ªé¡µé�¢æ˜¯å…³ä¸�å¹²å‡€çš„ï¼Œå®ƒå�ªå…³é—­å½“å‰�çš„ä¸€ä¸ªé¡µé�¢ã€‚ç¬¬äºŒä¸ªquitï¼Œ
//         * æ˜¯é€€å‡ºäº†æ‰€æœ‰Webdriveræ‰€æœ‰çš„çª—å�£ï¼Œé€€çš„é�žå¸¸å¹²å‡€ï¼Œæ‰€ä»¥æŽ¨è��ä½¿ç”¨quitæœ€ä¸ºä¸€ä¸ªcaseé€€å‡ºçš„æ–¹æ³•ã€‚
//         */
//        driver.quit();//é€€å‡ºæµ�è§ˆå™¨
//    }
//}

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;

import jxl.Cell;      
import jxl.Sheet;   
import jxl.Workbook;    

public class WebTest {
	private String baseUrl;
	private WebDriver driver;
	
	@Before
    public void setUp() throws Exception {
	    System.setProperty("webdriver.chrome.driver","chromedriver");//chromedriveræœ�åŠ¡åœ°å�€
        driver = new ChromeDriver(); //æ–°å»ºä¸€ä¸ªWebDriver çš„å¯¹è±¡ï¼Œä½†æ˜¯new çš„æ˜¯FirefoxDriverçš„é©±åŠ¨
        baseUrl = "https://psych.liebes.top/st";//æ‰“å¼€æŒ‡å®šçš„ç½‘ç«™
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);        
        } catch (Exception e) {
            e.printStackTrace();
        } 
     }
	@Test
    public void Test1() throws Exception {
         //ç›´æŽ¥ä»Žæœ¬åœ°æ–‡ä»¶åˆ›å»ºWorkbook  
         InputStream instream = new FileInputStream("input.xls");   
         Workbook readwb = Workbook.getWorkbook(instream);
         //Sheetçš„ä¸‹æ ‡æ˜¯ä»Ž0å¼€å§‹  
         //èŽ·å�–ç¬¬ä¸€å¼ Sheetè¡¨  
         Sheet readsheet = readwb.getSheet(0);  
         //èŽ·å�–Sheetè¡¨ä¸­æ‰€åŒ…å�«çš„æ€»åˆ—æ•°  
         int rsColumns = readsheet.getColumns();  
         //èŽ·å�–Sheetè¡¨ä¸­æ‰€åŒ…å�«çš„æ€»è¡Œæ•°  
         int rsRows = readsheet.getRows();  
         //èŽ·å�–æŒ‡å®šå�•å…ƒæ ¼çš„å¯¹è±¡å¼•ç”¨  
         for (int i = 0; i < rsRows; i++)  
         {  
             driver.get(baseUrl);
             Cell cell = readsheet.getCell(0, i); 
             String username = cell.getContents();
             String password = username.substring(4, 10);
             // é€šè¿‡ id æ‰¾åˆ° input çš„ DOM
             WebElement element = driver.findElement(By.id("username"));
             WebElement element1 = driver.findElement(By.id("password"));

             //System.out.println(element.getSize());  
             // è¾“å…¥å…³é”®å­—
             element.sendKeys(username);
             element1.sendKeys(password);

             // æ��äº¤ input æ‰€åœ¨çš„form
             element.submit();
            
             //èŽ·å�–å¾—åˆ°çš„é‚®ç®±
             WebElement element2 = driver.findElement(By.xpath("html/body/div/div/a/p"));
            
             String mailByWeb = element2.getText();
             String mailByInfo = readsheet.getCell(1,i).getContents();
            
             assertEquals(mailByInfo, mailByWeb);
            
             System.out.println(element2.getText());  
            
             System.out.println(username);  
         }          
         //å…³é—­è¯»å…¥æµ�
         readwb.close();         
   }
}