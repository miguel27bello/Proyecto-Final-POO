package test;

import controller.Controller;
import view.Login;

public class TestLogin {

	public static void main(String[] args) {
		Login login = new Login(new Controller());
		login.setVisible(true);
	}
}
