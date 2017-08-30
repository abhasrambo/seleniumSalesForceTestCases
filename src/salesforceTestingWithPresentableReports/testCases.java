package salesforceTestingWithPresentableReports;

import java.io.IOException;

public class testCases {
	public void testCasesContainer() throws IOException, InterruptedException{
		reusableMethod obj = new reusableMethod();
		loginTest.login();
		loginThenLogout.login();
		forgotPassword.login();
		loginFailed.login();
		Loginandclickuserprofile.login();
		setting.login();
		uploadPhoto.login();
		obj.bw.close();
	}
}
