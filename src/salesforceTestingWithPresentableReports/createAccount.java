package salesforceTestingWithPresentableReports;

/*Author: Abhas Kumar
 * Module Name: createAccount
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
public class createAccount {
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

			Sheet sheet = workbook.getSheet(7);
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
		obj.startReport("Create Account", "/Users/abhaskumar/Desktop/Report/");
		WebElement userName = driver.findElement(By.xpath(userNameXpath));
		obj.enterDataForMethodSetByFields(userName, username, objUsername );
		WebElement passWord = driver.findElement(By.xpath(passwordXpath));
		obj.enterDataForMethodSetByFields(passWord, password, objPassword );
		WebElement loginClick = driver.findElement(By.xpath(loginXpath));
		obj.click(loginClick, objLogin);
		Thread.sleep(4000);
		WebElement account = driver.findElement(By.linkText("Accounts"));
		obj.click(account, "Accounts");
		WebElement newOne = driver.findElement(By.name("new"));
		obj.click(newOne, "new");
		WebElement accountNew = driver.findElement(By.id("acc2"));
		obj.click(accountNew, "accountNew");
		WebElement save = driver.findElement(By.name("save"));
		obj.click(save, "save");
	 

	}
	

}
