package salesforceTestingWithPresentableReports;

/*Author: Abhas Kumar
 * Module Name: setting
 * Project Description: Read test values from excel and perform Login test action and then logout and performs action in settings
 * Date:August 29,2017
 */

import jxl.*;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.Scanner;
import org.eclipse.jetty.client.SendFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class setting {
	private static WebDriver driver;
	@SuppressWarnings("static-access")
	public static void login() throws IOException, InterruptedException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter absolute path of excel file");
		String path = sc.nextLine();
		String objUsername = "", username = "", userNameXpath = "",objPassword = "", password = "", passwordXpath = "", objLogin = "", loginXpath = "", objUserProfile = "", userProfileID = "";

		Workbook workbook = null;
		try{
			workbook = Workbook.getWorkbook(new File(path));

			Sheet sheet = workbook.getSheet(6);
			Cell cellOneOne = sheet.getCell(1, 1);
			objUsername = cellOneOne.getContents();

			Cell cellTwoOne = sheet.getCell(2, 1);
			username = cellTwoOne.getContents();

			Cell cellThreeOne = sheet.getCell(3, 1);
			userNameXpath = cellThreeOne.getContents();



			Cell cellOneTwo = sheet.getCell(1, 2);
			objPassword = cellOneTwo.getContents();

			Cell cellTwoTwo = sheet.getCell(2, 2);
			password = cellTwoTwo.getContents();

			Cell cellThreeTwo = sheet.getCell(3, 2);
			passwordXpath = cellThreeTwo.getContents();



			Cell cellOneOneThree = sheet.getCell(1, 3);
			objLogin= cellOneOneThree.getContents();
			

			Cell cellThree = sheet.getCell(3, 3);
			loginXpath = cellThree.getContents();
			
			
			
			Cell cellOneOneFour = sheet.getCell(1, 4);
			 objUserProfile = cellOneOneFour.getContents();
			Cell cellFour = sheet.getCell(3, 4);
			userProfileID= cellThree.getContents();
			
			
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		catch (BiffException e){
			e.printStackTrace();
		}
		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		reusableMethod obj = new reusableMethod();
		obj.startReport("Setting", "/Users/abhaskumar/Desktop/Report/");
		WebElement userName = driver.findElement(By.xpath(userNameXpath));
		obj.enterDataForMethodSetByFields(userName, username, objUsername );
		WebElement passWord = driver.findElement(By.xpath(passwordXpath));
		obj.enterDataForMethodSetByFields(passWord, password, objPassword );
		WebElement loginClick = driver.findElement(By.xpath(loginXpath));
		obj.click(loginClick, objLogin);
		Thread.sleep(4000);
		WebElement userProfileClick = driver.findElement(By.id("userNavLabel"));
		obj.click(userProfileClick, objUserProfile);
		WebElement setting = driver.findElement(By.linkText("My Settings"));
		obj.click(setting, "My Settings");
		WebElement info = driver.findElement(By.id("PersonalInfo_font"));
		obj.click(info, "Personal Info");
		WebElement loginHistory = driver.findElement(By.cssSelector("#LoginHistory_font > #LoginHistory_font"));
		obj.click(loginHistory, "Login history");
		WebElement displayLayout = driver.findElement(By.id("DisplayAndLayout_font"));
		obj.click(displayLayout, "Display Layout");
		WebElement customise = driver.findElement(By.cssSelector("#CustomizeTabs_font > #CustomizeTabs_font"));
		obj.click(customise, "customise tabs");
	    new Select(driver.findElement(By.id("p4"))).selectByVisibleText("Salesforce Chatter");
		WebElement email = driver.findElement(By.id("EmailSetup_font"));
		obj.click(email, "Email Set Up");
		WebElement emailFont = driver.findElement(By.cssSelector("#EmailSettings_font > #EmailSettings_font"));
		obj.click(emailFont, "Email Font Set up");
		WebElement personalCollaboration = driver.findElement(By.cssSelector("#PersonalCollaboration > a.header.setupFolder"));
		obj.click(personalCollaboration, "Personal collaboration");
		WebElement calander = driver.findElement(By.id("CalendarAndReminders_font"));
		obj.click(calander, "Callender and Reminder");
		WebElement reminderFont = driver.findElement(By.cssSelector("#Reminders_font > #Reminders_font"));
		obj.click(reminderFont, "Remonder Font");
		WebElement testButton = driver.findElement(By.id("testbtn"));
		obj.click(testButton, "Test Button");
	    
		

	}
	

}
