package logic;

import java.util.ArrayList;
import entity.Enterprise;
import exceptions.ErrorLoginFail;

public class DAOEnterprises {

	private ArrayList<Enterprise> enterprisesList;

	public DAOEnterprises() {
		enterprisesList = new ArrayList<>();
	}

	public ArrayList<Enterprise> getEnterprisesList() {
		return enterprisesList;
	}

	public void addEnterprise(Enterprise employee) {
		enterprisesList.add(employee);
	}

	public void deleteEnterprise(String nit) throws ErrorLoginFail {
		enterprisesList.remove(searchEnterprise(nit));
	}

	public int searchEnterprise(String nit) throws ErrorLoginFail {
		for (Enterprise enterprise : enterprisesList) {
			try {
				if (enterprise.getNit() == Long.valueOf(nit)) {
					return enterprisesList.indexOf(enterprise);
				}
			} catch (Exception e) {
				throw new ErrorLoginFail();
			}
		}
		throw new ErrorLoginFail();
	}

	public Enterprise getEnterprise(String nit) throws ErrorLoginFail {
		for (Enterprise enterprise : enterprisesList) {
			try {
				if (enterprise.getNit() == Long.valueOf(nit)) {
					return enterprise;
				}
			} catch (Exception e) {
				throw new ErrorLoginFail();
			}
		}
		throw new ErrorLoginFail();
	}

	public int sizeList() {
		return enterprisesList.size();
	}
}
