package com.ui.tests;

import static com.constants.Browser.*; //note this line 3:35:00 framework part 1
//control shift O remove unused imports
import com.ui.pages.HomePage;

public class LoginTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HomePage homePage = new HomePage(CHROME);
		String userName=homePage.goToLoginPage().doLoginWith("sogeh70447@harinv.com", "password").getUserName();
		System.out.println(userName);
	}

}
