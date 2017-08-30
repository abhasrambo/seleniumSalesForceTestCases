package salesforceTestingWithPresentableReports;

import java.io.IOException;

public class mainClass {
	public static void main(String[] args) throws IOException, InterruptedException
	{
		reusableMethod obj = new reusableMethod();
//		loginTest.login();
//		loginThenLogout.login();
//		forgotPassword.login();
//		loginFailed.login();
//		Loginandclickuserprofile.login();
		setting.login();
//		uploadPhoto.login();
		obj.bw.close();
	}
}

