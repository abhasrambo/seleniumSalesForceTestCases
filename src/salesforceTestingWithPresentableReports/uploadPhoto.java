package salesforceTestingWithPresentableReports;

/*Author: Abhas Kumar
 * Module Name: loginTest
 * Project Description: Read test values from excel and perform Login test action and then logout
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
public class uploadPhoto {
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

			Sheet sheet = workbook.getSheet(5);
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
		obj.startReport("Update profile", "/Users/abhaskumar/Desktop/Report/");
		WebElement userName = driver.findElement(By.xpath(userNameXpath));
		obj.enterDataForMethodSetByFields(userName, username, objUsername );
		WebElement passWord = driver.findElement(By.xpath(passwordXpath));
		obj.enterDataForMethodSetByFields(passWord, password, objPassword );
		WebElement loginClick = driver.findElement(By.xpath(loginXpath));
		obj.click(loginClick, objLogin);
		Thread.sleep(4000);
		WebElement userProfileClick = driver.findElement(By.id("userNavLabel"));
		obj.click(userProfileClick, objUserProfile);
		WebElement myProfile = driver.findElement(By.linkText("My Profile"));
		obj.click(myProfile, "My Profile");
		WebElement editProfile = driver.findElement(By.cssSelector("img[alt=\"Edit Profile\"]"));
		obj.click(editProfile, "Edit Profile");
		WebElement publishShare = driver.findElement(By.id("publishersharebutton"));
		obj.click(publishShare, "publish and Share");
		WebElement publishAttach = driver.findElement(By.id("publisherAttachContentPost"));
		obj.click(publishAttach, "publish and Attach");
		WebElement uploadFail = driver.findElement(By.id("chatterUploadFileAction"));
		obj.click(uploadFail, "Upload fail Action");
		WebElement file = driver.findElement(By.id("chatterFile"));
		obj.enterDataForMethodSetByFields(file, "/Users/abhaskumar/Desktop/test.docx",objUsername );
		WebElement publish = driver.findElement(By.id("publishersharebutton"));
		obj.click(publish, "publish");
		WebElement upload = driver.findElement(By.id("uploadLink"));
		obj.click(upload, "upload File");
		WebElement uploadPic = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		obj.click(uploadPic, "upload Photo");
	    driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile")).clear();
	    driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile")).sendKeys("/Users/abhaskumar/Desktop/1740387");
	    WebElement uploadComplete = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		obj.click(uploadComplete, "upload Photo Complete");
		WebElement saveOpload = driver.findElement(By.id("j_id0:j_id7:save"));
		obj.click(saveOpload, "Saved Photo");
	    
		

	}
	

}
