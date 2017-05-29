package test;

import java.io.IOException;

import entity.Enterprise;
import persistence.FileManagerEnterprises;

public class TestEnterprise {

	public static void main(String[] args) throws IOException {

		FileManagerEnterprises binary = new FileManagerEnterprises();

		binary.openEnterprisesFile(2, "registers/enterprises.byn");
		binary.writeEnterprise(new Enterprise(12341, "Rizzoli", "6456809", "admin1"));
		binary.writeEnterprise(new Enterprise(12342, "Doria", "6456808", "admin2"));
		binary.writeEnterprise(new Enterprise(12343, "Banco Corpbanca", "6456807", "admin3"));
		binary.writeEnterprise(new Enterprise(12344, "Subway", "6456806", "admin4"));
		binary.closeWriteEnterprises();

		Enterprise enterpriseAux = new Enterprise();

		binary.openEnterprisesFile(1, "registers/enterprises.byn");
		enterpriseAux = binary.readEnterprise();
		while (enterpriseAux != null) {
			System.out.println(enterpriseAux.getNit());
			System.out.println(enterpriseAux.getName());
			System.out.println(enterpriseAux.getPhone());
			System.out.println(enterpriseAux.getPassword());
			System.out.println("");
			enterpriseAux = binary.readEnterprise();
		}
	}
}
