package salesforceTestingWithPresentableReports;

/*Author: Abhas Kumar
 * Module Name: loginTest
 * Project Description: Read test values from excel and perform Login test action
 * Date:August 23,2017
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
public class forgotPassword {
	private static WebDriver driver;
	public static void login() throws IOException, InterruptedException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter absolute path of excel file");
		String path = sc.nextLine();
		String objUsername = "", username = "", userNameXpath = "",objForgotPassword = "", forgotPassword = "", forgotPasswordXpath = "", objUserNAME = "",userNAME = "", userNAMEXpath = "",objContinue = "",continueXPath = "";

		Workbook workbook = null;
		try{
			workbook = Workbook.getWorkbook(new File(path));

			Sheet sheet = workbook.getSheet(2);
			Cell cellOneOne = sheet.getCell(1, 1);
			objUsername = cellOneOne.getContents();

			Cell cellTwoOne = sheet.getCell(2, 1);
			username = cellTwoOne.getContents();

			Cell cellThreeOne = sheet.getCell(3, 1);
			userNameXpath = cellThreeOne.getContents();



			Cell cellOneTwo = sheet.getCell(1, 2);
			objForgotPassword = cellOneTwo.getContents();

			Cell cellTwoTwo = sheet.getCell(2, 2);
			forgotPassword = cellTwoTwo.getContents();

			Cell cellThreeTwo = sheet.getCell(3, 2);
			forgotPasswordXpath = cellThreeTwo.getContents();



			Cell cellOneOneThree = sheet.getCell(1, 3);
			objUsername = cellOneOneThree.getContents();
			
			Cell cellTwoThree = sheet.getCell(2, 4);
			userNAME = cellTwoTwo.getContents();

			Cell cellThree = sheet.getCell(3, 3);
			objUserNAME = cellThree.getContents();
			
			
			
			Cell cellOneOneFour = sheet.getCell(1, 4);
			objContinue = cellOneOneThree.getContents();

			Cell cellFour = sheet.getCell(3, 4);
			continueXPath = cellThree.getContents();

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
		obj.startReport("Forgot Password Report", "/Users/abhaskumar/Desktop/Report/");
		WebElement userName = driver.findElement(By.xpath(userNameXpath));
		obj.enterDataForMethodSetByFields(userName, username, objUsername );
		WebElement forgotpassWord = driver.findElement(By.id(forgotPasswordXpath));
		obj.click(forgotpassWord, objForgotPassword);
		WebElement userNameToRecoverPassword = driver.findElement(By.id("un"));
		obj.enterDataForMethodSetByFields(userNameToRecoverPassword, userNAME, objUserNAME );
		WebElement clickContinue = driver.findElement(By.id("continue"));
		obj.click(clickContinue, "Continue");
		
		
	

		

	}
	

}
