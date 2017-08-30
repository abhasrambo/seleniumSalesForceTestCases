package salesforceTestingWithPresentableReports;

import java.io.IOException;

public class testCases {
	@SuppressWarnings("static-access")
	public void testCasesContainer() throws IOException, InterruptedException{
		reusableMethod obj = new reusableMethod();
//		loginTest.login();
//		loginThenLogout.login();
//		forgotPassword.login();
//		loginFailed.login();
//		Loginandclickuserprofile.login();
//		setting.login();
//		uploadPhoto.login();
//		developerConsole.login();
//		logout.login();
		createAccount.login();
		obj.bw.close();
	}
}
