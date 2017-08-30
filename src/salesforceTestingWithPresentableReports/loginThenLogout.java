package salesforceTestingWithPresentableReports;

/*Author: Abhas Kumar
 * Module Name: loginThenLogout
 * Project Description: Read test values from excel and perform Login test action and then logout
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
public class loginThenLogout {
	private static WebDriver driver;
	public static void login() throws IOException, InterruptedException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter absolute path of excel file");
		String path = sc.nextLine();
		String objUsername = "", username = "", userNameXpath = "",objPassword = "", password = "", passwordXpath = "", objLogin = "", loginXpath = "", objUserProfile = "", userProfileID = "", objLogout = "", logoutID ="";

		Workbook workbook = null;
		try{
			workbook = Workbook.getWorkbook(new File(path));

			Sheet sheet = workbook.getSheet(1);
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
			
			
			Cell cellOneOneFive = sheet.getCell(1, 5);
			objLogout = cellOneOneFive.getContents();

			Cell cellFive = sheet.getCell(3, 5);
			logoutID = cellThree.getContents();

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
		obj.startReport("Login and Logout Report", "/Users/abhaskumar/Desktop/Report/");
		WebElement userName = driver.findElement(By.xpath(userNameXpath));
		obj.enterDataForMethodSetByFields(userName, username, objUsername );
		WebElement passWord = driver.findElement(By.xpath(passwordXpath));
		obj.enterDataForMethodSetByFields(passWord, password, objPassword );
		WebElement loginClick = driver.findElement(By.xpath(loginXpath));
		obj.click(loginClick, objLogin);
		Thread.sleep(4000);
		WebElement userProfileClick = driver.findElement(By.id("userNavLabel"));
		obj.click(userProfileClick, objUserProfile);
		WebElement logoutClick = driver.findElement(By.linkText("Logout"));
		obj.click(logoutClick, objLogout);

		

	}
	

}
