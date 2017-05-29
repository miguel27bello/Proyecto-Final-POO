package test;

import entity.Enterprise;
import view.WindowEnterprise;

public class TestWinEnterprise {

	public static void main(String[] args) {
		WindowEnterprise windowEnterprise = new WindowEnterprise(null,
				new Enterprise(1234, "Corpbanca", "7457017", "1234"));
		windowEnterprise.setVisible(true);
	}
}
