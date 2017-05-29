package test;

import java.io.IOException;

import entity.Career;
import entity.Graduated;
import persistence.FileManagerGraduates;

public class TestGraduated {

	public static void main(String[] args) throws IOException {

		FileManagerGraduates binary = new FileManagerGraduates();

		binary.openGraduatedsFile(2, "registers/graduates.byn");
		binary.writeGraduated(new Graduated(1054987010, "3115550001", "Laura", "Lopez", "Cra 9 #10-01",
				Career.ADMINISTRACION, "pass1"));
		binary.writeGraduated(new Graduated(1054987011, "3115550002", "Daniel", "Diaz", "Cra 9 #10-02",
				Career.ING_SISTEMAS_COMP, "pass2"));
		binary.writeGraduated(
				new Graduated(1054987012, "3115550003", "Jaime", "Junco", "Cra 9 #10-03", Career.QUIMICA, "pass3"));
		binary.closeWriteGraduates();

		Graduated graduated = new Graduated();
		binary.openGraduatedsFile(1, "registers/graduates.byn");
		graduated = binary.readGraduated();
		while (graduated != null) {
			System.out.println(graduated.getId());
			System.out.println(graduated.getName());
			System.out.println(graduated.getLastName());
			System.out.println(graduated.getAddress());
			System.out.println(graduated.getPhone());
			System.out.println(graduated.getCareer().getTipo());
			System.out.println(graduated.getPassword());
			System.out.println("");
			graduated = binary.readGraduated();
		}
	}
}
