package test;

import entity.Career;
import entity.Graduated;
import view.WindowGraduated;

public class TestWinGraduated {

	public static void main(String[] args) {
		WindowGraduated employee = new WindowGraduated(null, new Graduated(1049650969, "3176429615", "Daniel", "Reyes",
				"Cra 7 #17-92", Career.ING_SISTEMAS_COMP, "1234"));
		employee.setVisible(true);
	}
}
